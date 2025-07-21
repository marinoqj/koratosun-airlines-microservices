package es.koratosun.airlines.apigateway.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.koratosun.airlines.apigateway.application.CustomersServiceClient;
import es.koratosun.airlines.apigateway.domain.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/gateway")
public class ApiGatewayController {

    private final CustomersServiceClient customersServiceClient;

    public ApiGatewayController(CustomersServiceClient customersServiceClient) {
        this.customersServiceClient = customersServiceClient;
    }

    @GetMapping(value = "customers")
    public Flux<Customer> getCustomers() {
        return customersServiceClient.getCustomers();
    }
    
    @GetMapping(value = "customers/{idCustomer}")
    public Mono<Customer> getCustomer(final @PathVariable int idCustomer) {
        return customersServiceClient.getCustomer(idCustomer);
    }

    @PostMapping(value = "customers")
    public Mono<Customer> registerCustomer(@RequestBody Customer customer) {
        return customersServiceClient.registerCustomer(customer);
    }

    @DeleteMapping(value = "customers/{idCustomer}")
    public Mono<Void> deleteCustomer(final @PathVariable int idCustomer) {
        return customersServiceClient.deleteCustomer(idCustomer);
    }


}
