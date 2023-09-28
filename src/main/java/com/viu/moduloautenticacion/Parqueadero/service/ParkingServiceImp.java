package com.viu.moduloautenticacion.Parqueadero.service;

import com.viu.moduloautenticacion.Parqueadero.model.Parking;
import com.viu.moduloautenticacion.Parqueadero.repository.ParkingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ParkingServiceImp implements ParkingService {

    private ParkingRepository parkingRepository;

    @Override
    public Parking save(Parking parking) {
        return parkingRepository.save(parking);
    }

    @Override
    public Optional<Parking> findById(Long id) {
        return parkingRepository.findById(id);
    }
}
