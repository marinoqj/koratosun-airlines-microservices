package es.koratosun.airlines.webfrontboot.domain.form;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CustomerForm {

    private String idCustomer;
    private String name;
    private String firstSurname;
    private String secondSurname;
    private String address;
    private String municipality;
    private String postalCode;
    private String phone;
	
}
