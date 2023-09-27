package com.viu.moduloautenticacion.Usuario.modelo;

import com.viu.moduloautenticacion.Rol.modelo.Rol;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long usr_codigo;
    private String usr_nombre;
    private String usr_password;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "pertenece",
            joinColumns = @JoinColumn(name = "usr_codigo"),
            inverseJoinColumns = @JoinColumn(name = "rol_codigo")
    )
    Set<Rol> roles = new HashSet<>();

    public void addRol(Rol rol){
        this.roles.add(rol);
        rol.getUsuarios().add(this);
    }

}
