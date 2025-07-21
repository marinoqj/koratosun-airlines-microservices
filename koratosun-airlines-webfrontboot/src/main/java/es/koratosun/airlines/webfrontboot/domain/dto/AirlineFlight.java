package es.koratosun.airlines.webfrontboot.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

@Getter @Setter
public class AirlineFlight {

    private String codFlight;
    private String origin;
    private String destination;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private Integer seats;
    private String direction;
    private BigDecimal price;

    private LocalTime duration;

    public LocalTime getDuration() {
        Duration difference = Duration.between(departureTime, arrivalTime);

        // Obtener la diferencia en horas, minutos y segundos
        int hours = (int) difference.toHours();
        int minutes = (int) difference.toMinutes() % 60;
        int seconds = (int) difference.getSeconds() % 60;

        return LocalTime.of(hours, minutes, seconds);
    }
}
