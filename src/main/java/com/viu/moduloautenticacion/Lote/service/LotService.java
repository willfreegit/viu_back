package com.viu.moduloautenticacion.Lote.service;

import com.viu.moduloautenticacion.Lote.model.Lot;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public interface LotService {
    Lot save(Lot lot);
}
