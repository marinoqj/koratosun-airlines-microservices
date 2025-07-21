package es.koratosun.airlines.flights.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
public class ConnectionDTO {

    private Integer idConnection;
    private String destination;
    private String city;

    public ConnectionDTO(Integer idConnection, String destination, String city) {
        this.idConnection = idConnection;
        this.destination = destination;
        this.city = city;
    }
}
