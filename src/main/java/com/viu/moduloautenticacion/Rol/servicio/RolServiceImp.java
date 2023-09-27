package com.viu.moduloautenticacion.Rol.servicio;

import com.viu.moduloautenticacion.Rol.modelo.Rol;
import com.viu.moduloautenticacion.Rol.repositorio.RolRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class RolServiceImp implements RolService {

    private final RolRepository rolRepository;

    @Override
    public Rol saveRol(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Optional<Rol> findById(Long id) {
        return rolRepository.findById(id);
    }
}
