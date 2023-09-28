package com.viu.moduloautenticacion.Rol.service;

import com.viu.moduloautenticacion.Rol.model.Rol;
import com.viu.moduloautenticacion.Rol.repository.RolRepository;
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
