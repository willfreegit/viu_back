package com.viu.moduloautenticacion.Parqueadero.repositorio;


import com.viu.moduloautenticacion.Parqueadero.modelo.Parqueadero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParqueaderoRepository extends JpaRepository<Parqueadero, Long> {
}
