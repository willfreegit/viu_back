package com.viu.moduloautenticacion.Lote.service;

import com.viu.moduloautenticacion.Lote.model.Lot;
import com.viu.moduloautenticacion.Lote.repository.LotRepository;
import com.viu.moduloautenticacion.Parqueadero.model.Parking;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LotServiceImp implements LotService {

    private final LotRepository lotRepository;
    @Override
    public Lot save(Lot lot) {
        return lotRepository.save(lot);
    }

    @Override
    public Lot update(Long id, Lot parking) {
        Optional<Lot> parkingOptional = lotRepository.findById(id);
        if(parkingOptional.isPresent()){
            Lot old = parkingOptional.get();
            old.setCode(parking.getCode());
            old.setState(parking.getState());
            old.setType(parking.getType());
            return lotRepository.save(old);
        }
        return null;
    }

    @Override
    public List<Lot> findByParkingId(long id) {
        return lotRepository.findByParkingId(id);
    }

    @Override
    public Lot delete(Long id) {
        Optional<Lot> parkingOptional = lotRepository.findById(id);
        if(parkingOptional.isPresent()){
            Lot old = parkingOptional.get();
            old.setDeleted(true);
            return lotRepository.save(old);
        }
        return null;
    }
}
