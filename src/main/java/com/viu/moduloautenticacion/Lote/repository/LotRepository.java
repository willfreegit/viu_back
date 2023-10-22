package com.viu.moduloautenticacion.Lote.repository;

import com.viu.moduloautenticacion.Cost.Model.Cost;
import com.viu.moduloautenticacion.Lote.model.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LotRepository extends JpaRepository<Lot, Long> {
    @Query("select lot from Lot lot where lot.parking.id_parking=?1 and lot.deleted != '1'")
    List<Lot> findByParkingId(Long id);
}
