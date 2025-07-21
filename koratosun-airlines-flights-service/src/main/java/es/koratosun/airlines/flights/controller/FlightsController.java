package es.koratosun.airlines.flights.controller;

import java.util.List;

import es.koratosun.airlines.flights.domain.dto.ListFlightsConnectionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.koratosun.airlines.flights.controller.constants.UrlConstants;
import es.koratosun.airlines.flights.domain.Connection;
import es.koratosun.airlines.flights.domain.Destination;
import es.koratosun.airlines.flights.domain.AirlineFlight;
import es.koratosun.airlines.flights.domain.dto.ConnectionDTO;
import es.koratosun.airlines.flights.service.FlightsService;
import io.micrometer.core.annotation.Timed;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;


@RequestMapping(UrlConstants.URL_FLIGHTS)
@RestController
@Timed("koratosun-airlines.flights")
public class FlightsController {

    private static final Logger log = LoggerFactory.getLogger(FlightsController.class);

    public static final String COD_ORIGIN = "codOrigin";
    public static final String ORIGIN = "origin";
    public static final String ID_CONNECTION = "idConnection";

    private FlightsService flightsService;
    
    @Autowired
    public FlightsController(FlightsService flightsService) {
		super();
		this.flightsService = flightsService;
	}


	@GetMapping
    public List<Destination> getDestinations() {
    	
    	return flightsService.getDestinations();

    }
	

	@GetMapping(value = UrlConstants.COD_ORIGIN_PATH)
    public List<Connection> getConnections(@PathVariable(COD_ORIGIN) @Size(min = 3, max = 3) String codOrigin) {
    	
		List<Connection> connections = flightsService.getConnectionsByOrigen(codOrigin);
		
		connections.forEach(c -> {
			if(c.getDestination().getCodDestination().equals(codOrigin)){
				
				Destination temp = c.getDestination();
				c.setDestination(c.getOrigin());
				// Para que no quede raro el JSON
				c.setOrigin(temp);
			}});
		
		
    	return connections;

    }	

    @GetMapping(value = UrlConstants.ID_CONNECTION_PATH )
    public List<AirlineFlight> getFlightsConnection(@PathVariable(ID_CONNECTION) @Min(1) int idConnection) {

        return flightsService.getFlightsConnection(idConnection);

    }

    @GetMapping(value = UrlConstants.CONNECTIONS_DEPARTURE_ARRIVAL_PATH)
    public ListFlightsConnectionDTO getRoutesConnection(@PathVariable("departure") @Size(min = 3, max = 3) String departure,
                                                     @PathVariable("arrival") @Size(min = 3, max = 3) String arrival) {
        return flightsService.getRoutesConnection(departure, arrival);
    }

    @GetMapping(value = UrlConstants.DESTINATIONS_PATH)
    public List<ConnectionDTO> getConnectionOrigin(@PathVariable(ORIGIN) @Size(min = 3, max = 3) String origin) {

        return flightsService.getConnections(origin);

    }

}
