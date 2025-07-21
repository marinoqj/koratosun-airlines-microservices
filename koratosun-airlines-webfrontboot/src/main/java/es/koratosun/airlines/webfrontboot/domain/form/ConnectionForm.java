package es.koratosun.airlines.webfrontboot.domain.form;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ConnectionForm {
    private String departure;
    private String arrival;
    private String departureCityAirport;
    private String arrivalCityAirport;
    private String departingTime;
    private String arrivingTime;
}
