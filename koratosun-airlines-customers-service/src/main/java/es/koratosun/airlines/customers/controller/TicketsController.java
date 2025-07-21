package es.koratosun.airlines.customers.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.koratosun.airlines.customers.controller.constants.UrlConstants;
import es.koratosun.airlines.customers.controller.request.TicketRequest;
import es.koratosun.airlines.customers.domain.Ticket;
import es.koratosun.airlines.customers.domain.Customer;
import es.koratosun.airlines.customers.ext.exceptions.ResourceNotFoundException;
import es.koratosun.airlines.customers.service.TicketsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;


@RequestMapping(UrlConstants.URL_TICKETS)
@RestController
//@Timed("airlines.ticket")
public class TicketsController {

    private static final Logger log = LoggerFactory.getLogger(TicketsController.class);
    
    public static final String ID_TICKET = "idTicket";
    public static final String ID_CUSTOMER = "idCustomer";
    
    private TicketsService ticketsService;

    @Autowired
	public TicketsController(TicketsService ticketsService) {
			super();
			this.ticketsService = ticketsService;
		}


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket createTicket(@Valid @RequestBody TicketRequest ticketRequest) {
    	
    	Ticket ticket = new Ticket();
    	
    	BeanUtils.copyProperties(ticketRequest, ticket);
    	
    	Customer customer = new Customer();
    	customer.setIdCustomer(ticketRequest.idCustomer());
    	
    	ticket.setCustomer(customer);
    	
    	return ticketsService.insertUpdate(ticket);
    }

    
    @GetMapping(value = UrlConstants.ID_TICKET_PATH)
    public Optional<Ticket> getTicket(@PathVariable(ID_TICKET) @Min(1) int idTicket) {
        return ticketsService.getTicketById(idTicket);
    }


    @GetMapping
    public List<Ticket> getTickets() {
        return ticketsService.getTickets();
    }
    
    @GetMapping(value = UrlConstants.ID_TICKETS_CUSTOMER_PATH)
    public List<Ticket> getTicketsByCustomer(@PathVariable(ID_CUSTOMER) @Min(1) int idCustomer) {
        return ticketsService.getTicketsByCustomer(idCustomer);
    }


    @PutMapping(value = UrlConstants.ID_TICKET_PATH)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTicket(@PathVariable(ID_TICKET) @Min(1) int idTicket, @Valid @RequestBody TicketRequest ticketRequest) {
        
    	final Ticket entity = ticketsService.getTicketById(idTicket).orElseThrow(() -> new ResourceNotFoundException("Ticket " + idTicket + " not found"));

    	BeanUtils.copyProperties(ticketRequest, entity);
    	
    	ticketsService.insertUpdate(entity);
    }
}
