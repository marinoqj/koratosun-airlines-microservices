package es.koratosun.airlines.flights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@EnableDiscoveryClient
@SpringBootApplication
public class AirlinesFlightsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlinesFlightsServiceApplication.class, args);
	}
}
