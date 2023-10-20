package com.viu.moduloautenticacion.Cost.Respository;

import com.viu.moduloautenticacion.Cost.Model.Cost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CostRepository extends JpaRepository<Cost, Long> {

    @Query("select cost from Cost cost where cost.parking.id_parking=?1")
    List<Cost> findAllByParking(Long id);
}
