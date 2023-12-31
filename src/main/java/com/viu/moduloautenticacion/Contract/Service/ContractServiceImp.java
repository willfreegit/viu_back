package com.viu.moduloautenticacion.Contract.Service;

import com.viu.moduloautenticacion.Contract.Model.Contract;
import com.viu.moduloautenticacion.Contract.Respository.ContractRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContractServiceImp implements ContractService {

    private final ContractRespository contractRespository;
    @Override
    public Contract save(Contract contract) {
        return contractRespository.save(contract);
    }

    @Override
    public Optional<Contract> findById(Long id) {
        return contractRespository.findById(id);
    }

    @Override
    public List<Contract> findByLotId(Long id) {
        return contractRespository.findByLotId(id);
    }

    @Override
    public Contract update(Long id, Contract contract) {
        Optional<Contract> old = contractRespository.findById(id);
        if(old.isPresent()){
            Contract update = old.get();
            update.setState(contract.getState());
            return contractRespository.save(update);
        }
        return new Contract();
    }
}
