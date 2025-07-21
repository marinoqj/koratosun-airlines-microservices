package es.koratosun.airlines.webfrontboot.service.impl;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import es.koratosun.airlines.webfrontboot.domain.Customer;
import es.koratosun.airlines.webfrontboot.service.BaseService;
import es.koratosun.airlines.webfrontboot.service.CustomersService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomersServiceImpl extends BaseService implements CustomersService {

	
	// API acting like proxy
//	public List<Customer> getCustomers() {
//		return webClient.get()
//				.uri(serverName + ":" + port + context + "/customers")
//				.retrieve()
//				.bodyToFlux(Customer.class)
//				.collectList()
//				.block();
//	}
	
	
	public List<Customer> getCustomers() {
		return webClient.get()
				.uri(serverName + ":" + port + context + "/gateway/customers")
				.retrieve()
				.bodyToFlux(Customer.class)
				.collectList()
				.block();
	}

	public Customer getCustomerById(String id) {
		return webClient.get()
				.uri(serverName + ":" + port + context + "/customers/" + id)
				.retrieve()
				.bodyToMono(Customer.class)
				.block();
	}

	public Customer updateCustomer(Customer customer) {

		return webClient.put().uri(serverName + ":" + port + context + "/customers").body(Mono.just(customer), Customer.class).retrieve().bodyToMono(Customer.class).block();

	}

	public Customer insertCustomer(Customer customer) {
		return webClient.post().uri(serverName + ":" + port + context + "/customers").body(Mono.just(customer), Customer.class).retrieve().bodyToMono(Customer.class).block();

	}

	@Override
	public void deleteCustomer(String id) {
		// webClient.delete().uri(serverName + ":" + port + context + "/customers/" + id).retrieve().bodyToMono(String.class).block();

		webClient.delete()
				.uri(serverName + ":" + port + context + "/customers/" + id)
				.retrieve()
				.toBodilessEntity()
				.block();
	}
	
	
	// Added to pass throw the API and go to Kafka
	public Customer registerCustomer(Customer customer) {
		return webClient.post().uri(serverName + ":" + port + context + "/gateway/customers").body(Mono.just(customer), Customer.class).retrieve().bodyToMono(Customer.class).block();

	}

}
