package com.utn.ejer01;

import com.utn.ejer01.entidades.*;
import com.utn.ejer01.repositorios.ClienteRepository;
import com.utn.ejer01.repositorios.PedidoRepository;
import com.utn.ejer01.repositorios.RubroRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class Ejer01Application {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	RubroRepository rubroRepository;

	public static void main(String[] args) {

		SpringApplication.run(Ejer01Application.class, args);

	}

	@Bean
	CommandLineRunner init(ClienteRepository clienteRepository) {
		return args -> {

		//Llenando tablas

			Cliente cliente01 = Cliente.builder()
					.nombre("Lucio")
					.apellido("Fernandez")
					.telefono("2614682315")
					.email("lucio@gmail.com")
					.build();

			Cliente cliente02=Cliente.builder()
					.nombre("Juan")
					.apellido("Torres")
					.telefono("2613614859")
					.email("Juan@gmail.com")
					.build();

			Domicilio domicilio01 = Domicilio.builder()
					.calle("San Martin")
					.numero("1234")
					.localidad("Dorrego")
					.build();

			Domicilio domicilio02 = Domicilio.builder()
					.calle("Corrientes")
					.numero("5678")
					.localidad("6ta Seccion")
					.build();

			Domicilio domicilio03= Domicilio.builder()
					.calle("España")
					.numero("9875")
					.localidad("Ciudad")
					.build();

			Pedido pedido01= Pedido.builder()
					.fecha(LocalDate.now())
					.estado("Terminado")
					.tipoEnvio("Retiro")
					.total(23500)
					.build();

			Pedido pedido02= Pedido.builder()
					.fecha(LocalDate.now())
					.estado("En proceso")
					.tipoEnvio("A domicilio")
					.total(95000)
					.build();


			DetallePedido detalle01= DetallePedido.builder()
					.cantidad(2000)
					.subtotal(3200)
					.build();

			DetallePedido detalle02= DetallePedido.builder()
					.cantidad(9000)
					.subtotal(7000)
					.build();

			Factura factura01=Factura.builder()
					.numero(12345)
					.fecha(LocalDate.now())
					.descuento(1)
					.total(999)
					.build();



			Factura factura02=Factura.builder()
					.numero(2113)
					.fecha(LocalDate.now())
					.descuento(20)
					.total(200)
					.build();


			Rubro rubro01=Rubro.builder()
					.denominacion("RUBRO 1")
					.build();

			Producto producto01= Producto.builder()
					.tipo("Insumo")
					.tiempoEstimadoCocina(25)
					.denominacion("Pizza")
					.precioCompra(1000)
					.precioVenta(3500)
					.stockActual(120)
					.stockMinimo(56)
					.unidadMedida("KG")
					.receta("Masa, salsa y queso")
					.build();

			//Creando relaciones
			cliente01.setDomicilio(domicilio01);
			cliente01.setDomicilio(domicilio02);
			cliente01.setPedido(pedido01);
			cliente01.setPedido(pedido02);

			cliente02.setDomicilio(domicilio03);

			pedido01.setDetalle(detalle01);
			pedido01.setDetalle(detalle02);
			pedido01.setFactura(factura01);
			pedido02.setFactura(factura02);

			detalle01.setProducto(producto01);

			detalle02.setProducto(producto01);

			rubro01.setProductos(producto01);

			//Guardar
			rubroRepository.save(rubro01);

			clienteRepository.save(cliente01);
			clienteRepository.save(cliente02);

		//Consultas
			System.out.println("Cliente 1");
		Cliente clienteObtenido=clienteRepository.findById(cliente01.getId()).orElse(null);

		if(clienteObtenido != null){

			System.out.println(("Nombre: " + clienteObtenido.getNombre()));
			System.out.println(("Apellido: " + clienteObtenido.getApellido()));
			System.out.println(("Telefono: " + clienteObtenido.getTelefono()));
			System.out.println(("Email: " + clienteObtenido.getEmail()));

			clienteObtenido.mostrarDomicilios();
		}


		};

	}



}