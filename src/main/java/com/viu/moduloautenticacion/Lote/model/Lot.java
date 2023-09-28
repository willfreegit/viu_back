package com.viu.moduloautenticacion.Lote.model;

import com.viu.moduloautenticacion.Parqueadero.model.Parking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long lot_code;
    private String lot_state;
    private String lot_type;

    @ManyToOne
    @JoinColumn(name = "par_code", nullable = false)
    private Parking parking;
}
