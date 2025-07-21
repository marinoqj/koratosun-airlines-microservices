package es.koratosun.airlines.customers.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "clientes")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Integer idCustomer;

    @Column(name = "NOMBRE")
    @NotBlank
    private String name;

    @Column(name = "APELLIDO1")
    @NotBlank
    private String firstSurname;
    
    @Column(name = "APELLIDO2")
    private String secondSurname;

    @Column(name = "DIRECCION")
    @NotBlank
    private String address;

    @Column(name = "MUNICIPIO")
    @NotBlank
    private String municipality;
    
    @Column(name = "COD_POSTAL")
    @NotBlank
    private String postalCode;

    @Column(name = "TELEFONO")
    @NotBlank
    @Digits(fraction = 0, integer = 9)
    private String phone;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
    private Set<Ticket> tickets;

}
