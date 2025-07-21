package es.koratosun.airlines.webfrontboot.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ListFlightsConnection {
    private List<AirlineFlight> flightsFromOrigin;
    private List<AirlineFlight> flightsFromDestination;
}


