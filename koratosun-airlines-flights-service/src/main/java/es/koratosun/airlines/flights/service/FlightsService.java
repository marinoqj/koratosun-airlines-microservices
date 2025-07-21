package es.koratosun.airlines.flights.service;

import java.util.List;

import es.koratosun.airlines.flights.domain.Connection;
import es.koratosun.airlines.flights.domain.Destination;
import es.koratosun.airlines.flights.domain.AirlineFlight;
import es.koratosun.airlines.flights.domain.dto.ConnectionDTO;
import es.koratosun.airlines.flights.domain.dto.ListFlightsConnectionDTO;

public interface FlightsService {
	

	List<Destination> getDestinations();
	
	List<Destination> getConnectedCities(String codDestination);
	
	List<AirlineFlight> getFlightsConnection(Integer idConnection);

	List<ConnectionDTO> getConnections(String origin);

	ListFlightsConnectionDTO getRoutesConnection(String departure, String arrival);
	
	List<Connection> getConnectionsByOrigen(String origin);
}
