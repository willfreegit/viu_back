package com.viu.moduloautenticacion.Usuario.service;

import com.viu.moduloautenticacion.Usuario.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    User saveUsuario(User user);

    Optional<User> findById(Long id);

    Optional<User> getByUserName(String userName);

    boolean existsByEmail(String email);
}
