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
@Table(name= "cliente")
public class Cliente extends BaseEntidad {
   private String nombre;
   private String apellido;
   private String telefono;
   private String email;

   //relacion domicilio
   @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
   @JoinColumn(name = "Cliente_id") //me crea la fk en domicilio
   @Builder.Default
   private List<Domicilio> domicilios=new ArrayList<>();
   public void setDomicilio(Domicilio domi){
      domicilios.add(domi);
   }
   public void mostrarDomicilios(){
      System.out.println("Domicilios de " +nombre+" "+apellido+ ":");
      for (Domicilio domicilio: domicilios){
         System.out.println("Calle: " +domicilio.getCalle() + ",Numero: "+domicilio.getNumero()+", Localidad: " +domicilio.getLocalidad());
      }
   }


   //relacion pedido
   @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
   @JoinColumn(name = "id_cliente")
   @Builder.Default
   private List<Pedido> pedidos=new ArrayList<>();

   public void setPedido(Pedido pedi){
      pedidos.add(pedi);
   }

}
