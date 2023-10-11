package com.viu.moduloautenticacion.Lote.model;

import com.viu.moduloautenticacion.Contract.Model.Contract;
import com.viu.moduloautenticacion.Cost.Model.Cost;
import com.viu.moduloautenticacion.Parqueadero.model.Parking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long lot_code;
    private String lot_id;
    private String lot_type;
    private String lot_state;
    private String lot_style;
    private String lot_clicked;
    private boolean deleted = Boolean.FALSE;

    @ManyToOne
    @JoinColumn(name = "par_code", nullable = false)
    private Parking parking;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Contract> contracts;
}
