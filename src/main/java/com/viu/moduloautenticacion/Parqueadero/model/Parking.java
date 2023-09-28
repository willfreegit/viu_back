package com.viu.moduloautenticacion.Parqueadero.model;

import com.viu.moduloautenticacion.Lote.model.Lot;
import com.viu.moduloautenticacion.Usuario.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long par_code;
    private String par_name;
    private String par_address;
    private String par_longitude;
    private String par_latitude;
    private String par_state;

    @OneToMany
    private Set<User> users;
    @OneToMany
    private Set<Lot> lots;
}
