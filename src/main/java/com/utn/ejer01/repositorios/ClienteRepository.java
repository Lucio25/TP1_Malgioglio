package com.utn.ejer01.repositorios;

import com.utn.ejer01.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente,Long>{
}
