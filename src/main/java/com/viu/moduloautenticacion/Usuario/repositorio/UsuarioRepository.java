package com.viu.moduloautenticacion.Usuario.repositorio;

import com.viu.moduloautenticacion.Rol.modelo.Rol;
import com.viu.moduloautenticacion.Usuario.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
