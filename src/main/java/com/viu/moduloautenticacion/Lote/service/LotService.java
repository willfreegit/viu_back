package com.viu.moduloautenticacion.Lote.service;

import com.viu.moduloautenticacion.Lote.model.Lot;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public interface LotService {
    Lot save(Lot lot);

    List<Lot> findByParkingId(long id);
}
