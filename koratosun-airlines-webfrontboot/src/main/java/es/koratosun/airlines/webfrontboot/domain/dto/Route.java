package es.koratosun.airlines.webfrontboot.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Route {
    private AirlineFlight outboundFlight;
    private AirlineFlight returnFlight;
}
