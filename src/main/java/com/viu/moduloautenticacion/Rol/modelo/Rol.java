package com.viu.moduloautenticacion.Rol.modelo;

import com.viu.moduloautenticacion.Usuario.modelo.Usuario;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rol_codigo;
    private String rol_descripcion;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },mappedBy = "roles")
    Set<Usuario> usuarios = new HashSet<>();
}
