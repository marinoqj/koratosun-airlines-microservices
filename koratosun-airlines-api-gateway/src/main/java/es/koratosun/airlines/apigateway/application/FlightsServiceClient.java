package es.koratosun.airlines.apigateway.application;

import es.koratosun.airlines.apigateway.domain.Customer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class FlightsServiceClient {

    private final WebClient.Builder webClientBuilder;

    public FlightsServiceClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Flux<Customer> getCustomers() {
        return webClientBuilder.build().get()
            .uri("http://customers-service/customers")
            .retrieve()
            .bodyToFlux(Customer.class);
    }

    public Mono<Customer> getCustomer(final int id) {
        return webClientBuilder.build().get()
            .uri("http://customers-service/customers/" + id)
            .retrieve()
            .bodyToMono(Customer.class);
    }
}
