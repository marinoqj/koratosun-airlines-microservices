package es.koratosun.airlines.customers.controller.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;

public record CustomerRequest(Integer idCustomer, @NotBlank String name,
                           @NotBlank String firstSurname,
                           String secondSurname,
                           @NotBlank String address,
                           @NotBlank String municipality,
                           @NotBlank String postalCode,
                           @NotBlank
                           @Digits(fraction = 0, integer = 9)
                           String phone)
{}


