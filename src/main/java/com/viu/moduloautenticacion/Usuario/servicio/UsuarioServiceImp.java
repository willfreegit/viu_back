package com.viu.moduloautenticacion.Usuario.servicio;

import com.viu.moduloautenticacion.Usuario.modelo.Usuario;
import com.viu.moduloautenticacion.Usuario.repositorio.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class UsuarioServiceImp implements UsuarioService{

    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }
}
