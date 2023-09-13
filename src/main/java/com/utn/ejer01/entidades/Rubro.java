package com.utn.ejer01.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name= "rubro")
public class Rubro extends BaseEntidad{
    private String denominacion;

    //relacion producto
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "Rubro_ID") //me crea la fk en producto
    @Builder.Default
    private List<Producto> productos=new ArrayList<>();
    public void setProductos(Producto producto){
        productos.add(producto);
    }

}
