package com.viu.moduloautenticacion.Usuario.servicio;

import com.viu.moduloautenticacion.Usuario.modelo.Usuario;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UsuarioService {
    Usuario saveUsuario(Usuario usuario);

    Optional<Usuario> findById(Long id);
}
