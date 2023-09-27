package com.viu.moduloautenticacion.Rol.servicio;

import com.viu.moduloautenticacion.Rol.modelo.Rol;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RolService {

    Rol saveRol(Rol rol);

    Optional<Rol> findById(Long id);
}
