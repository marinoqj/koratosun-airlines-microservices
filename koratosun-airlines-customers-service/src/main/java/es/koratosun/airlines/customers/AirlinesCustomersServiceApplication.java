package es.koratosun.airlines.customers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class AirlinesCustomersServiceApplication {
	
	private static final Logger log = LoggerFactory.getLogger(AirlinesCustomersServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AirlinesCustomersServiceApplication.class, args);
		
		log.info("##################################### Customers Service UP #####################################");
	}
}
