package es.koratosun.airlines.customers.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.koratosun.airlines.customers.domain.Customer;
import es.koratosun.airlines.customers.repository.CustomersRepository;
import es.koratosun.airlines.customers.service.CustomersService;

@Service
public class CustomersServiceImpl implements CustomersService {
	
	private static Logger log = LogManager.getLogger(CustomersServiceImpl.class);

	@Value("${topic}")
	String topic;
	
	private CustomersRepository customersRepository;
	
	KafkaTemplate<String,es.koratosun.airlines.apigateway.domain.Customer> kafkaTemplate;
	

	public CustomersServiceImpl(CustomersRepository customersRepository) {
		super();
		this.customersRepository = customersRepository;
	}


	@Override
	public Customer insertUpdate(Customer customer) {
		return customersRepository.save(customer);
	}


	@Override
	public Optional<Customer> getCustomerById(int idCustomer) {
		return customersRepository.findById(idCustomer);
	}


	@Override
	public List<Customer> getCustomers() {
		return customersRepository.findAll();
	}

	@Override
	public void deleteCustomer(int idCustomer) {
		customersRepository.deleteById(idCustomer);
	}


	@KafkaListener(topics = "customers", groupId = "kortosunairlines")
	public void receivedMessage(es.koratosun.airlines.apigateway.domain.Customer message) throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(message);
		
		log.info("Customer recieved from kafka queue: " + jsonString);
		
		Customer newCustomer = new Customer();
		
		BeanUtils.copyProperties(message, newCustomer);
		
		customersRepository.save(newCustomer);
		
	}

}
