package com.viu.moduloautenticacion.Cost.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.viu.moduloautenticacion.Parqueadero.model.Parking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_cost;
    private String type;
    private BigDecimal cost;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_parking", nullable = false)
    private Parking parking;
}
