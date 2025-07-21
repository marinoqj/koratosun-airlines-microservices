package es.koratosun.airlines.webfrontboot.controller;

import es.koratosun.airlines.webfrontboot.controller.constants.UrlConstants;
import es.koratosun.airlines.webfrontboot.domain.Connection;
import es.koratosun.airlines.webfrontboot.domain.Destination;
import es.koratosun.airlines.webfrontboot.service.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FrontController {

    private static final String MSG_OPTIONS = "messageOpciones";

    private final FlightsService flightsService;

    @Autowired
    public FrontController(FlightsService flightsService) {
        this.flightsService = flightsService;
    }

    @GetMapping(UrlConstants.ROOT)
    public String loadStart(Model model) {
        return loadPage("inicio", model);
    }

    
    @GetMapping(UrlConstants.INICIO_PAGE)
    public String loadPage(@PathVariable String page, Model model) {
        if ("inicio".equals(page)) {
            loadSelectDestinations(model);
            loadSelectConnections(null, model);
        }

        return page;
    }

    @GetMapping("/contact")
    public String loadContact() {
        return "contact";
    }

    @GetMapping("/popular-routes")
    public String loadPopularRoutes() {
        return "popular-routes";
    }

    @PostMapping(UrlConstants.LOAD_CONNECTIONS)
    public String loadConnections(@RequestParam("origin") String origin, Model model) {
        loadSelectDestinations(model);
        loadSelectConnections(origin, model);

        model.addAttribute("departureSelected", origin);
        return "inicio";
    }

    private void loadSelectConnections(String origin, Model model) {
        List<Connection> connections = new ArrayList<>();
        if (origin != null) {
            connections = flightsService.getConnectionsByOrigen(origin);
            model.addAttribute("connections", connections);
        }

        if (!connections.isEmpty() || origin == null) {
            model.addAttribute(MSG_OPTIONS, "Select arrival airport");
        } else {
            model.addAttribute(MSG_OPTIONS, "No connections available");
        }

        model.addAttribute("connections", connections);
    }

    private void loadSelectDestinations(Model model) {
        List<Destination> destinations = flightsService.getDestinations();
        model.addAttribute("destinations", destinations);
    }

}
