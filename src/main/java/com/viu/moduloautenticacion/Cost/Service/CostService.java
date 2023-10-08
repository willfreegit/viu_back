package com.viu.moduloautenticacion.Cost.Service;

import com.viu.moduloautenticacion.Cost.Model.Cost;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CostService {
    Optional<Cost> findById(Long id);

    Cost save(Cost cost);

    List<Cost> findByParking(Long id);
}
