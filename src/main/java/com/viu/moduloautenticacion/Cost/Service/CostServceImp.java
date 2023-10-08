package com.viu.moduloautenticacion.Cost.Service;

import com.viu.moduloautenticacion.Cost.Model.Cost;
import com.viu.moduloautenticacion.Cost.Respository.CostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CostServceImp implements CostService{

    private final CostRepository costRepository;
    @Override
    public Optional<Cost> findById(Long id) {
        return costRepository.findById(id);
    }

    @Override
    public Cost save(Cost cost) {
        return costRepository.save(cost);
    }

    @Override
    public List<Cost> findByParking(Long id) {
        return costRepository.findAllByParking(id);
    }
}
