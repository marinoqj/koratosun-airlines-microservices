package es.koratosun.airlines.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.koratosun.airlines.customers.domain.Customer;

public interface CustomersRepository extends JpaRepository<Customer, Integer> { }
