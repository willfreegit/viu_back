package com.viu.moduloautenticacion.Usuario.repository;

import com.viu.moduloautenticacion.Usuario.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);


    boolean existsByEmail(String email);
}
