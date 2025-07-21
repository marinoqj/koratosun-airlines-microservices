package es.koratosun.airlines.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.koratosun.airlines.customers.domain.Ticket;

import java.util.List;


public interface TicketsRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findByCustomerIdCustomer(int idCustomer);
}

