package es.koratosun.airlines.customers.controller.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TicketRequest(@NotNull Integer idCustomer,
							 @NotBlank String bookingCode,
							 @Future @JsonFormat(pattern = "dd/MM/yyyy")Date purchaseDate, 
							 @DecimalMin(value="10.0") Double price) {

}
