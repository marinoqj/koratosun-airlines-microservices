package es.koratosun.airlines.customers.controller;

import io.micrometer.core.annotation.Timed;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import es.koratosun.airlines.customers.controller.constants.UrlConstants;
import es.koratosun.airlines.customers.controller.request.CustomerRequest;
import es.koratosun.airlines.customers.domain.Customer;
import es.koratosun.airlines.customers.ext.exceptions.ResourceNotFoundException;
import es.koratosun.airlines.customers.service.CustomersService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping(UrlConstants.URL_CUSTOMERS)
@RestController
@Timed("koratosun-airlines.customers")
public class CustomersController {

    private static final Logger log = LoggerFactory.getLogger(CustomersController.class);
    
    public static final String ID_CUSTOMER = "idCustomer";
    
    private CustomersService customersService;
    

    @Autowired
	public CustomersController(CustomersService customersService) {
			super();
			this.customersService = customersService;
		}


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
    	
    	Customer customer = new Customer();
    	    	    
    	BeanUtils.copyProperties(customerRequest, customer);
    	
    	return customersService.insertUpdate(customer);
    }

    
    @GetMapping(value = UrlConstants.ID_CUSTOMER_PATH)
    public Optional<Customer> getCustomer(@PathVariable(ID_CUSTOMER) @Min(1) int idCustomer) {
        return customersService.getCustomerById(idCustomer);
    }


    @GetMapping
    public List<Customer> getCustomers() {
    	
    	List<Customer> result = customersService.getCustomers();
    	
        return result;
    }


    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Customer updateCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
        
    	final Customer entity = customersService.getCustomerById(customerRequest.idCustomer()).orElseThrow(() -> new ResourceNotFoundException("Customer " + customerRequest.idCustomer() + " not found"));

    	BeanUtils.copyProperties(customerRequest, entity);
    	
    	 return customersService.insertUpdate(entity);
    }

    @DeleteMapping(value = UrlConstants.ID_CUSTOMER_PATH)
    public List<Customer> deleteCustomer(@PathVariable(ID_CUSTOMER) @Min(1) int idCustomer) {
        customersService.deleteCustomer(idCustomer);
        return getCustomers();
    }
    

}
