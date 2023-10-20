package com.viu.moduloautenticacion.Contract.Model;

import com.viu.moduloautenticacion.Lote.model.Lot;
import com.viu.moduloautenticacion.Parqueadero.model.Parking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_contract;
    private String state;
    private String register;
    private Date time_in;
    private Date time_out;
    private int time_total;
    private BigDecimal price;
    private BigDecimal total;
    private boolean deleted = Boolean.FALSE;

    @ManyToOne
    @JoinColumn(name = "id_lot", nullable = false)
    private Lot lot;

}
