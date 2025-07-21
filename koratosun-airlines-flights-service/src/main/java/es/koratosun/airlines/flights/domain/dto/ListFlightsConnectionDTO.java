package es.koratosun.airlines.flights.domain.dto;

import es.koratosun.airlines.flights.domain.AirlineFlight;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ListFlightsConnectionDTO {
    private List<AirlineFlight> flightsFromOrigin;
    private List<AirlineFlight> flightsFromDestination;
}
