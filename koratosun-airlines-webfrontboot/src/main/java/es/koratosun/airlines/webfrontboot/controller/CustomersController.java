package es.koratosun.airlines.webfrontboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.koratosun.airlines.webfrontboot.controller.constants.ForwardConstants;
import es.koratosun.airlines.webfrontboot.controller.constants.UrlConstants;
import es.koratosun.airlines.webfrontboot.domain.Customer;
import es.koratosun.airlines.webfrontboot.domain.form.CustomerForm;
import es.koratosun.airlines.webfrontboot.service.CustomersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class CustomersController {
	
	private CustomersService customersService;
	

	public CustomersController(CustomersService customersService) {
		super();
		this.customersService = customersService;
	}

	@GetMapping(value=UrlConstants.LIST_CUSTOMERS)
	public String listCustomers(Map<String, Object> map, HttpServletRequest request){

		List<Customer> customers = customersService.getCustomers();
		map.put("customers", customers);

		return ForwardConstants.FWD_LIST_CUSTOMERS;
	}
	
	
	@GetMapping(value = UrlConstants.VER_CREATE_CUSTOMER)
	public String viewCreateCustomer(Model model, HttpServletRequest request) {

		CustomerForm customerForm = new CustomerForm();

		model.addAttribute("mode", "insert");
		model.addAttribute("customerForm", customerForm);
		
		return ForwardConstants.FWD_CUSTOMER_FORM;

	}
	
	@PostMapping(value = UrlConstants.INSERT_CUSTOMER)
	public String insertCustomer(@Valid CustomerForm formulario, BindingResult result,  Model model, HttpServletRequest request) {
		
		String destination = null;
		Customer entity = new Customer();
		
		
		if(result.hasErrors()) {
			
			model.addAttribute("mode", "insert");
			
			destination = ForwardConstants.FWD_CUSTOMER_FORM;
			
		}else {
			
			BeanUtils.copyProperties(formulario, entity);	

			customersService.insertCustomer(entity);

			destination = ForwardConstants.RED_LIST_CUSTOMERS;
		}
				

		return destination;
	}
	
	@PostMapping(value = UrlConstants.EDIT_CUSTOMER)
	public String editCustomer(@RequestParam("idCustomer") String idCustomer, Model model, HttpServletRequest request) {

		CustomerForm customerForm = new CustomerForm();
		
		Customer customer = customersService.getCustomerById(idCustomer);

		BeanUtils.copyProperties(customer, customerForm);
		
		customerForm.setIdCustomer(customer.getIdCustomer().toString());
		
		model.addAttribute("mode", "update");
		model.addAttribute("customerForm", customerForm);
		
		return ForwardConstants.FWD_CUSTOMER_FORM;

	}
	
	
	@PostMapping(value = UrlConstants.UPDATE_CUSTOMER)
	public String updateCustomer(@Valid CustomerForm formulario, BindingResult result,  Map<String, Object> map, HttpServletRequest request) {
		
		
		if(result.hasErrors()) {
			
			map.put("mode", "update");
			
			return ForwardConstants.FWD_CUSTOMER_FORM;
			
		}else {
		
			// Recupero el customer para mantener la password
			Customer customer  = customersService.getCustomerById(formulario.getIdCustomer());
			
			BeanUtils.copyProperties(formulario, customer);
			
			customer.setIdCustomer(Integer.valueOf(formulario.getIdCustomer()));
				
			customersService.updateCustomer(customer);
			
			map.put("message", "The customer was updated successfully");
		
			return listCustomers(map, request);  // Utilizo dos return para poder pasar el message
		}
	}


	@PostMapping(value = UrlConstants.DELETE_CUSTOMER)
	public String deleteCustomer(@RequestParam("idCustomer") String idCustomer, Model model, HttpServletRequest request) {
		customersService.deleteCustomer(idCustomer);
		model.addAttribute("message", "The customer was deleted successfully");
		return listCustomers(model.asMap(), request);
	}

	//  #####################################################
	//   Below here I add the logic for customer registration
	//  #####################################################
	
	@PostMapping(value = UrlConstants.SHOW_CUSTOMER_REGISTRATION)
	public String viewCustomerRegistration(Model model, HttpServletRequest request) {

		CustomerForm customerForm = new CustomerForm();

		model.addAttribute("mode", "register");
		model.addAttribute("customerForm", customerForm);
		
		return ForwardConstants.FWD_CUSTOMER_REGISTRATION_FORM;

	}

	@PostMapping(value = UrlConstants.REGISTER_CUSTOMER)
	public String registertCustomer(@Valid CustomerForm formulario, BindingResult result,  Model model, HttpServletRequest request) {
		
		String destination = null;
		Customer entity = new Customer();
		
		
		if(result.hasErrors()) {
			
			model.addAttribute("mode", "register");
			
			destination = ForwardConstants.FWD_CUSTOMER_REGISTRATION_FORM;
			
		}else {
			
			BeanUtils.copyProperties(formulario, entity);	

			customersService.registerCustomer(entity);
			
			model.addAttribute("message", "Customer registration completed");

			destination = ForwardConstants.FWD_MESSAGE;
		}
				

		return destination;
	}
	
}
