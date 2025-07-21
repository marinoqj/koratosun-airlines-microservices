package es.koratosun.airlines.flights.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.koratosun.airlines.flights.domain.Destination;

public interface DestinationsRepository extends JpaRepository<Destination, String> { }
