package es.koratosun.airlines.webfrontboot.service;

import es.koratosun.airlines.webfrontboot.domain.Connection;
import es.koratosun.airlines.webfrontboot.domain.Destination;
import es.koratosun.airlines.webfrontboot.domain.dto.AirlineFlight;
import es.koratosun.airlines.webfrontboot.domain.dto.ListFlightsConnection;


import java.util.List;

public interface FlightsService {

    List<Destination> getDestinations();

    List<Connection> getConnections(String origin);
    
    List<Connection> getConnectionsByOrigen(String origin);

    List<AirlineFlight> getFlightsConnection(String connection);

    // /flights/connections/1
    ListFlightsConnection getRoutesConnection(String departure, String arrival);
}
