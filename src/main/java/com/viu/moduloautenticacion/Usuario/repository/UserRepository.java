package com.viu.moduloautenticacion.Usuario.repository;

import com.viu.moduloautenticacion.Usuario.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
