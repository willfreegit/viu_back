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
    private long tar_code;
    private String tar_type;
    private BigDecimal tar_cost;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "par_code", nullable = false)
    private Parking parking;
}
