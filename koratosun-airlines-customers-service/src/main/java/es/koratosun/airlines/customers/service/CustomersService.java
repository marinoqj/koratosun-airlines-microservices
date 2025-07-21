package es.koratosun.airlines.customers.service;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;

import es.koratosun.airlines.customers.domain.Customer;

public interface CustomersService {
	
	Customer insertUpdate(Customer customer);
	
	Optional<Customer> getCustomerById(int customer);
	
	List<Customer> getCustomers();

    void deleteCustomer(int idCustomer);
    
    
    
}
