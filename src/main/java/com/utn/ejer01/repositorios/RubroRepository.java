package com.utn.ejer01.repositorios;

import com.utn.ejer01.entidades.Cliente;
import com.utn.ejer01.entidades.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RubroRepository  extends JpaRepository<Rubro,Long> {
}
