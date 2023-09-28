package com.viu.moduloautenticacion.Parqueadero.service;

import com.viu.moduloautenticacion.Parqueadero.model.Parking;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ParkingService {
    Parking save(Parking parking);

    Optional<Parking> findById(Long id);
}
