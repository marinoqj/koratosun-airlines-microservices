package es.koratosun.airlines.customers.service;

import java.util.List;
import java.util.Optional;

import es.koratosun.airlines.customers.domain.Ticket;

public interface TicketsService {
	
	Ticket insertUpdate(Ticket ticket);
	
	Optional<Ticket> getTicketById(int ticket);
	
	List<Ticket> getTickets();

	List<Ticket> getTicketsByCustomer(int idCustomer);

}
