package com.viu.moduloautenticacion.Parqueadero.servicio;

import com.viu.moduloautenticacion.Parqueadero.modelo.Parqueadero;
import com.viu.moduloautenticacion.Parqueadero.repositorio.ParqueaderoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParqueaderoServiceImp implements ParqueaderoService {

    private ParqueaderoRepository parqueaderoRepository;

    @Override
    public Parqueadero save(Parqueadero parqueadero) {
        return parqueaderoRepository.save(parqueadero);
    }
}
