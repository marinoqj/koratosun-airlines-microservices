package es.koratosun.airlines.apigateway.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCustomer", scope = Customer.class)
@Getter @Setter
public class Customer {

    private Integer idCustomer;
    private String name;
    private String firstSurname;
    private String secondSurname;
    private String address;
    private String municipality;
    private String postalCode;
    private String phone;
	
}
