package es.koratosun.airlines.webfrontboot.service.impl;


import es.koratosun.airlines.webfrontboot.domain.Connection;
import es.koratosun.airlines.webfrontboot.domain.Destination;
import es.koratosun.airlines.webfrontboot.domain.dto.AirlineFlight;
import es.koratosun.airlines.webfrontboot.domain.dto.ListFlightsConnection;
import es.koratosun.airlines.webfrontboot.service.BaseService;
import es.koratosun.airlines.webfrontboot.service.FlightsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightsServiceImpl extends BaseService implements FlightsService {

    @Override
    public List<Destination> getDestinations() {
        return webClient.get().uri(serverName + ":" + port + context + "/flights").retrieve().bodyToFlux(Destination.class).collectList().block();
    }

    @Override
    public List<Connection> getConnections(String origin) {
        String url = "/flights/destinations/" + origin;

        return webClient.get().uri(serverName + ":" + port + context + url).retrieve().bodyToFlux(Connection.class).collectList().block();
    }

    // /flights/connections/1
    @Override
    public List<AirlineFlight> getFlightsConnection(String connection) {
        String url = "/flights/connections/" + connection;

        return webClient.get().uri(serverName + ":" + port + context + url).retrieve().bodyToFlux(AirlineFlight.class).collectList().block();
    }

    // /flights/connections/MAD/BCN
    @Override
    public ListFlightsConnection getRoutesConnection(String departure, String arrival) {
        String url = "/flights/connections/" + departure + "/" + arrival;

        return webClient.get()
                .uri(serverName + ":" + port + context + url)
                .retrieve()
                .bodyToMono(ListFlightsConnection.class)
                .block();
    }

	@Override
	public List<Connection> getConnectionsByOrigen(String origin) {
        String url = "/flights/" + origin;

        return webClient.get().uri(serverName + ":" + port + context + url).retrieve().bodyToFlux(Connection.class).collectList().block();
	}

}
