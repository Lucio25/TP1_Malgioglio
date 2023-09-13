package com.utn.ejer01.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name= "detallePedido")
public class DetallePedido extends BaseEntidad {
    private int cantidad;
    private double subtotal;
    @ManyToOne
    @JoinColumn(name = "producto_id") // Esto mapea la columna "producto_id" en la tabla Detalle de Pedido
    private Producto producto;
}
