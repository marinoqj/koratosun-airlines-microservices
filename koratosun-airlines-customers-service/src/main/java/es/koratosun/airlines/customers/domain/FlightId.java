package es.koratosun.airlines.customers.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FlightId implements Serializable {
    
    private String flightCode;
    private Date date;
}
