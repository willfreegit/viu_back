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
    private long id_lot;
    private String code;
    private String type;
    private String state;
    private String style;
    private String clicked;
    private boolean deleted = Boolean.FALSE;

    @Transient
    private String contract_id;
    @Transient
    private String contract_register;


    @ManyToOne
    @JoinColumn(name = "id_parking", nullable = false)
    private Parking parking;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Contract> contracts;
}
