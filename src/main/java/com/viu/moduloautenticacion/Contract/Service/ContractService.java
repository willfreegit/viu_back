package com.viu.moduloautenticacion.Contract.Service;

import com.viu.moduloautenticacion.Contract.Model.Contract;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ContractService {


    Contract save(Contract contract);

    Optional<Contract> findById(Long id);

    List<Contract> findByLotId(Long id);
}
