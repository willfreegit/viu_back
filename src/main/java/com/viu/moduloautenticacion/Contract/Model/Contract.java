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
    private Long con_code;
    private String con_state;
    private String con_register;
    private Date con_timeIn;
    private Date con_timeOut;
    private int con_timeTotal;
    private BigDecimal con_price;
    private BigDecimal con_total;
    private boolean deleted = Boolean.FALSE;

    @ManyToOne
    @JoinColumn(name = "lot_code", nullable = false)
    private Lot lot;

}
