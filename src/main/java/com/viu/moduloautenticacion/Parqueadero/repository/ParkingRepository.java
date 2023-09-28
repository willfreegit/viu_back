package com.viu.moduloautenticacion.Parqueadero.repository;


import com.viu.moduloautenticacion.Parqueadero.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<Parking, Long> {
}
