package com.viu.moduloautenticacion.Contract.Respository;


import com.viu.moduloautenticacion.Contract.Model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContractRespository extends JpaRepository<Contract, Long> {

    @Query("SELECT c FROM Contract c WHERE c.lot.id_lot=?1")
    public List<Contract> findByLotId(Long id);
}
