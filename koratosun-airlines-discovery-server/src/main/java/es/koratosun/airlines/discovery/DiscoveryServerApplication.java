package es.koratosun.airlines.discovery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;



@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {
	
	private static final Logger log = LoggerFactory.getLogger(DiscoveryServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerApplication.class, args);
		
		log.info("##################################### Dicovery Server UP #####################################");
	}
}
