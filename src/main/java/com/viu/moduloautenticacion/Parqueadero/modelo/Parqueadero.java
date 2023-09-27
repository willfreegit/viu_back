package com.viu.moduloautenticacion.Parqueadero.modelo;

import com.viu.moduloautenticacion.Usuario.modelo.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Parqueadero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long par_codigo;
    private String par_nombre;
    private String par_direccion;
    private String par_longitud;
    private String par_latitud;
    private String par_estado;

    @OneToMany
    private Set<Usuario> usuarios;
}
