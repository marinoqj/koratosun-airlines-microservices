package es.koratosun.airlines.flights.repository;

import java.util.List;

import es.koratosun.airlines.flights.domain.dto.ConnectionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import es.koratosun.airlines.flights.domain.Connection;
import es.koratosun.airlines.flights.domain.Destination;

public interface ConnectionsRepository extends JpaRepository<Connection, Integer> {
	
	@Query("SELECT d FROM Connection c, Destination d WHERE (c.origin.codDestination LIKE :codDestination AND d.codDestination = c.destination.codDestination) "
			+ "OR (c.destination.codDestination LIKE :codDestination AND d.codDestination = c.origin.codDestination)")
	List<Destination> getConnectedCities(@RequestParam String codDestination);
	
	@Query("SELECT c FROM Connection c, Destination d WHERE (c.origin.codDestination LIKE :codDestination AND d.codDestination = c.destination.codDestination) "
			+ "OR (c.destination.codDestination LIKE :codDestination AND d.codDestination = c.origin.codDestination)")
	List<Connection> getConnections(@RequestParam String codDestination);

	@Query(value = "SELECT c.id_conexion AS idConexion, c.destino AS destino, d.city AS city " +
			"FROM conexiones c " +
			"JOIN destinos d ON c.destino = d.cod_destino " +
			"WHERE c.origin = :origin " +
			"ORDER BY d.city", nativeQuery = true)
	List<ConnectionDTO> findConnectionsByOrigenNative(@RequestParam("origin") String origin);

}
