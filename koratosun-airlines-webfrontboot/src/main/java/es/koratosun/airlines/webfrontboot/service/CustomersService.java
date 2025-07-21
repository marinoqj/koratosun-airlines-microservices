package es.koratosun.airlines.webfrontboot.service;

import java.util.List;

import es.koratosun.airlines.webfrontboot.domain.Customer;


public interface CustomersService {

	List<Customer> getCustomers();
	
	Customer getCustomerById(String id);
	
	Customer updateCustomer(Customer customer);
	
	Customer insertCustomer(Customer customer);

	void deleteCustomer(String id);
	
	Customer registerCustomer(Customer customer);
	
}
