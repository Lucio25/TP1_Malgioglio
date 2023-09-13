package com.utn.ejer01.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name= "pedido")
public class Pedido extends BaseEntidad {
    private LocalDate fecha;
    private String estado;
    private String tipoEnvio;
    private double total;
//relacion detalle pedido
//relacion domicilio
@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
@JoinColumn(name = "Id_pedido") //me crea la fk en detalle pedido
@Builder.Default
private List<DetallePedido> detallePedidos=new ArrayList<>();
    public void setDetalle(DetallePedido detalle){
        detallePedidos.add(detalle);
    }
    //relacion factura
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ID_FACTURA")
    private Factura factura;
}

