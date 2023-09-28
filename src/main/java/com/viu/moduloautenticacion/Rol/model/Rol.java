package com.viu.moduloautenticacion.Rol.model;

import com.viu.moduloautenticacion.Usuario.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rol_code;
    private String rol_description;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },mappedBy = "roles")
    Set<User> users = new HashSet<>();
}
