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
    public Parking update(Long id, Parking parking) {
        Optional<Parking> parkingOptional = parkingRepository.findById(id);
        if(parkingOptional.isPresent()){
            Parking old = parkingOptional.get();
            old.setAddress(parking.getAddress());
            old.setLatitude(parking.getLatitude());
            old.setLongitude(parking.getLongitude());
            old.setName(parking.getName());
            old.setAttention(parking.getAttention());
            return parkingRepository.save(old);
        }
        return null;
    }

    @Override
    public Optional<Parking> findById(Long id) {
        return parkingRepository.findById(id);
    }
}
