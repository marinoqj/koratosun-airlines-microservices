package es.koratosun.airlines.customers.domain;

import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "vuelos")
@IdClass(FlightId.class)
public class FlightCustomer {
    
	@Id    
    @Column(name = "COD_VUELO")
    private String flightCode;
    
    @Id
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date;

    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm")
    @Column(name = "HORA_SALIDA")
    private LocalTime departureTime;

    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm")
    @Column(name = "HORA_LLEGADA")
    private LocalTime arrivalTime;

    
    @Column(name = "ORIGEN")
    private String origin;

    @Column(name = "DESTINO")
    private String destination;

    @ManyToOne
    @JoinColumn(name = "ID_BILLETE")
    @JsonIgnore
    private Ticket ticket;
    
    //private String asiento;

}
