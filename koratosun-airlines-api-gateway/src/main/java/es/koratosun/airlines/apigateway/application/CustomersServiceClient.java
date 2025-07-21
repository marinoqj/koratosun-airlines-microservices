package es.koratosun.airlines.apigateway.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.text.MessageFormat;
import java.util.concurrent.CompletableFuture;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.koratosun.airlines.apigateway.domain.Customer;
import es.koratosun.airlines.apigateway.ext.Constants;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CustomersServiceClient {
	
	@Value("${topic}")
	String topic;
	
	private static Logger log = LogManager.getLogger(CustomersServiceClient.class);

    private final WebClient.Builder webClientBuilder;
    
    KafkaTemplate<String,Customer> kafkaTemplate;

    public CustomersServiceClient(WebClient.Builder webClientBuilder, KafkaTemplate<String,Customer> kafkaTemplate) {
        this.webClientBuilder = webClientBuilder;
        this.kafkaTemplate = kafkaTemplate;
    }

    public Flux<Customer> getCustomers() {
        return webClientBuilder.build().get()
            .uri("http://customers-service/customers")
            .retrieve()
            .bodyToFlux(Customer.class);
    }

    public Mono<Customer> getCustomer(final int id) {
        return webClientBuilder.build().get()
            .uri("http://customers-service/" + id)
            .retrieve()
            .bodyToMono(Customer.class);
    }

    public Mono<Void> deleteCustomer(int idCustomer) {
        return webClientBuilder.build().delete()
            .uri("http://customers-service/" + idCustomer)
            .retrieve()
            .bodyToMono(Void.class);
    }

    
    public Mono<Customer> registerCustomer(Customer customer) {
        
    	Mono<Customer> resultado = null;
    	
    	try {

    		// En lugar de insertar el cliente y luego enviarlo a la cola kafka, lo voy a enviar a la cola y luego insertarlo desde un consumer en el microservicio de customers
//    		resultado = webClientBuilder.build().post().uri("http://customers-service/customers").body(Mono.just(customer), Customer.class).retrieve().bodyToMono(Customer.class);
//    		
//    		if(resultado != null) {
    			
    			CompletableFuture<SendResult<String,Customer>> future = kafkaTemplate.send(topic, customer);    			
    			future.whenCompleteAsync((r,t)->{
    				
    				if(t != null) {
    					throw new RuntimeException();
    				}
    				
    				log.info("Customer sent to kafka queue: "+ r.getProducerRecord().value().getName() + " " +  r.getProducerRecord().value().getFirstSurname() + " " +  r.getProducerRecord().value().getSecondSurname()  +" registered in topic "+r.getRecordMetadata().topic());
    			});
//    		}
    		
    	}catch(Exception ex) {
    		log.error(MessageFormat.format(Constants.MESSAGE_EXCEPTION_PREFIX, ex.getMessage())); 
    	}
    	
    	return resultado;
    }
    
}
