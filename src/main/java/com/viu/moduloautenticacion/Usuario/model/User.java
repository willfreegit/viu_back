package com.viu.moduloautenticacion.Usuario.model;

import com.viu.moduloautenticacion.Parqueadero.model.Parking;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "userName"),
        @UniqueConstraint(columnNames = "email")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_user;
    private String userName;
    private String email;
    private String password;
    private String role;

    @ManyToOne
    @JoinColumn(name = "id_parking")
    private Parking parking;
}
