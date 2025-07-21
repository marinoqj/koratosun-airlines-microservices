package es.koratosun.airlines.flights.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.koratosun.airlines.flights.domain.AirlineFlight;

public interface AirlineFlightRepository extends JpaRepository<AirlineFlight, String> { }
