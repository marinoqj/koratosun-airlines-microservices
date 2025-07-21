package es.koratosun.airlines.flights.domain.dto;

import es.koratosun.airlines.flights.domain.AirlineFlight;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Route {
    private AirlineFlight outboundFlight;
    private AirlineFlight returnFlight;
}
