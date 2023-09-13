package com.utn.ejer01.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name= "factura")
public class Factura extends BaseEntidad {
    private int numero;
    private LocalDate fecha;
    private double descuento;
    private int total;


}
