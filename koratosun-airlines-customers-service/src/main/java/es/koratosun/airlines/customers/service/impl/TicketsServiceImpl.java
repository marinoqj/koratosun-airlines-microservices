package es.koratosun.airlines.customers.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.koratosun.airlines.customers.domain.Ticket;
import es.koratosun.airlines.customers.repository.TicketsRepository;
import es.koratosun.airlines.customers.service.TicketsService;

@Service
public class TicketsServiceImpl implements TicketsService {

	private TicketsRepository ticketsRepository;
	
	@Autowired
	public TicketsServiceImpl(TicketsRepository ticketsRepository) {
		super();
		this.ticketsRepository = ticketsRepository;
	}


	@Override
	public Ticket insertUpdate(Ticket ticket) {
		return ticketsRepository.save(ticket);
	}


	@Override
	public Optional<Ticket> getTicketById(int idTicket) {
		return ticketsRepository.findById(idTicket);
	}


	@Override
	public List<Ticket> getTickets() {
		return ticketsRepository.findAll();
	}

	@Override
	public List<Ticket> getTicketsByCustomer(int idCustomer) {
		return ticketsRepository.findByCustomerIdCustomer(idCustomer);
	}

}
