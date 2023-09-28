package com.viu.moduloautenticacion.Lote.service;

import com.viu.moduloautenticacion.Lote.model.Lot;
import com.viu.moduloautenticacion.Lote.repository.LotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LotServiceImp implements LotService {

    private final LotRepository lotRepository;
    @Override
    public Lot save(Lot lot) {
        return lotRepository.save(lot);
    }
}
