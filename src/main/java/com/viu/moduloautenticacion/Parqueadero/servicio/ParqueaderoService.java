package com.viu.moduloautenticacion.Parqueadero.servicio;

import com.viu.moduloautenticacion.Parqueadero.modelo.Parqueadero;
import org.springframework.stereotype.Service;

@Service
public interface ParqueaderoService {
    Parqueadero save(Parqueadero parqueadero);
}
