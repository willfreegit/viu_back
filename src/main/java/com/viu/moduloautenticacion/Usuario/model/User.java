package com.viu.moduloautenticacion.Usuario.model;

import com.viu.moduloautenticacion.Parqueadero.model.Parking;
import com.viu.moduloautenticacion.Rol.model.Rol;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long usr_code;
    private String usr_name;
    private String usr_password;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "belongs",
            joinColumns = @JoinColumn(name = "usr_code"),
            inverseJoinColumns = @JoinColumn(name = "rol_code")
    )
    Set<Rol> roles = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "par_code", nullable = false)
    private Parking parking;
}
