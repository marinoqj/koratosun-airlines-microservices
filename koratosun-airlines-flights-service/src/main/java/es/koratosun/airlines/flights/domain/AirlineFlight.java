package es.koratosun.airlines.flights.domain;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "vuelos")
public class AirlineFlight {
    
    @Id
    @Column(name = "COD_VUELO")
	private String codFlight;
    @Column(name = "ORIGEN")
	private String origin;
    @Column(name = "DESTINO")
	private String destination;
    @Column(name = "HORA_SALIDA")
	private LocalTime departureTime;
    @Column(name = "HORA_LLEGADA")
	private LocalTime arrivalTime;
    @Column(name = "PLAZAS")
	private Integer seats;
    @Column(name = "SENTIDO")
	private String direction;

    @Column(name= "PRECIO", precision = 3, scale = 0, nullable = false)
    @Min(value = 0, message = "The price cannot be negative")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "ID_CONEXION")
    @JsonIgnore
	private Connection connection;

}
