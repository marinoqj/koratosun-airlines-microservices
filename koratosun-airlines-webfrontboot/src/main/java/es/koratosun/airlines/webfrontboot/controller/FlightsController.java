package es.koratosun.airlines.webfrontboot.controller;

import es.koratosun.airlines.webfrontboot.controller.constants.ForwardConstants;
import es.koratosun.airlines.webfrontboot.controller.constants.UrlConstants;
import es.koratosun.airlines.webfrontboot.domain.dto.ListFlightsConnection;
import es.koratosun.airlines.webfrontboot.domain.dto.Route;
import es.koratosun.airlines.webfrontboot.domain.dto.AirlineFlight;
import es.koratosun.airlines.webfrontboot.domain.form.ConnectionForm;
import es.koratosun.airlines.webfrontboot.ext.utils.tools.DateUtils;


import es.koratosun.airlines.webfrontboot.service.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FlightsController {

    private final FlightsService flightsService;

    @Autowired
    public FlightsController(FlightsService flightsService) {
        this.flightsService = flightsService;
    }

    @PostMapping(UrlConstants.SEARCH_ROUTES_CONNECTION)
    public String buscarConnections(ConnectionForm formulario, Model model) {
        String departure = formulario.getDeparture();
        String arrival = formulario.getArrival();

        String departingTime = formulario.getDepartingTime();

        boolean isSameDay = true;
        if (departingTime != null && !departingTime.isEmpty()) {
            isSameDay = departingTime.equals(formulario.getArrivingTime());
        }

        ListFlightsConnection listFlightsConnection = flightsService.getRoutesConnection(departure, arrival);

        List<Route> routes = new ArrayList<>();
        for (AirlineFlight ida : listFlightsConnection.getFlightsFromOrigin()) {
            for (AirlineFlight comeBack : listFlightsConnection.getFlightsFromDestination()) {
                if (isSameDay && ida.getArrivalTime().isAfter(comeBack.getDepartureTime())) {
                    continue; // Usa 'continue' para evitar añadir combinaciones no válidas
                }

                Route route = new Route(); // Crear nueva instancia aquí
                route.setOutboundFlight(ida);
                route.setReturnFlight(comeBack);
                routes.add(route);
            }
        }

        String departingTimeFormatted = DateUtils.cambioFormatoFecha(departingTime, "yyyy-MM-dd", "dd/MM/yyyy");
        String arrivingTimeFormatted = DateUtils.cambioFormatoFecha(formulario.getArrivingTime(), "yyyy-MM-dd", "dd/MM/yyyy");
        model.addAttribute("routes", routes);
        model.addAttribute("departure", formulario.getDepartureCityAirport());
        model.addAttribute("arrival", formulario.getArrivalCityAirport());
        model.addAttribute("departingTime", departingTimeFormatted);
        model.addAttribute("arrivingTime", arrivingTimeFormatted);

        return ForwardConstants.FWD_LIST_ROUTES;
    }
}
