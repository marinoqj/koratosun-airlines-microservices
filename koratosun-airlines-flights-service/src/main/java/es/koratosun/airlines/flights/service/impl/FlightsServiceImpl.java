package es.koratosun.airlines.flights.service.impl;

import es.koratosun.airlines.flights.domain.AirlineFlight;
import es.koratosun.airlines.flights.domain.Connection;
import es.koratosun.airlines.flights.domain.Destination;
import es.koratosun.airlines.flights.domain.dto.ConnectionDTO;
import es.koratosun.airlines.flights.domain.dto.ListFlightsConnectionDTO;
import es.koratosun.airlines.flights.repository.ConnectionsRepository;
import es.koratosun.airlines.flights.repository.DestinationsRepository;
import es.koratosun.airlines.flights.repository.AirlineFlightRepository;
import es.koratosun.airlines.flights.service.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightsServiceImpl implements FlightsService {

	private DestinationsRepository destinationsRepository;
	
	private ConnectionsRepository connectionsRepository;
	
	private AirlineFlightRepository airlineFlightRepository;

	@Autowired
	public FlightsServiceImpl(DestinationsRepository destinationsRepository, ConnectionsRepository connectionsRepository,
			AirlineFlightRepository airlineFlightRepository) {
		super();
		this.destinationsRepository = destinationsRepository;
		this.connectionsRepository = connectionsRepository;
		this.airlineFlightRepository = airlineFlightRepository;
	}

	@Override
	public List<Destination> getDestinations() {
		return destinationsRepository.findAll();
	}

	@Override
	public List<Destination> getConnectedCities(String codDestination) {
		return connectionsRepository.getConnectedCities(codDestination);
	}

	@Override
	public List<AirlineFlight> getFlightsConnection(Integer idConnection) {
		AirlineFlight filter = new AirlineFlight();
		Connection connection = new Connection();
		connection.setIdConnection(idConnection);
		filter.setConnection(connection);

		Example<AirlineFlight> example = Example.of(filter);

		Sort order = Sort.by(Sort.Order.asc("departureTime"));
				
		return airlineFlightRepository.findAll(example, order);
	}

	@Override
	public List<ConnectionDTO> getConnections(String origin) {
		return connectionsRepository.findConnectionsByOrigenNative(origin);
	}

	public ListFlightsConnectionDTO getRoutesConnection(String departure, String arrival) {
		ListFlightsConnectionDTO result = new ListFlightsConnectionDTO();

		List<AirlineFlight> flightsFromOrigin = getVuelosOrigenDestination(departure, arrival);
		List<AirlineFlight> flightsFromDestination = getVuelosOrigenDestination(arrival, departure);

		result.setFlightsFromOrigin(flightsFromOrigin);
		result.setFlightsFromDestination(flightsFromDestination);

		return result;
	}

	private List<AirlineFlight> getVuelosOrigenDestination(String departure, String arrival) {
		AirlineFlight filter = new AirlineFlight();
		filter.setOrigin(departure);
		filter.setDestination(arrival);

        Example<AirlineFlight> example = Example.of(filter);

		Sort order = Sort.by(Sort.Order.asc("departureTime"));
		return airlineFlightRepository.findAll(example, order);
	}

	@Override
	public List<Connection> getConnectionsByOrigen(String origin) {
		return connectionsRepository.getConnections(origin);
	}

}
