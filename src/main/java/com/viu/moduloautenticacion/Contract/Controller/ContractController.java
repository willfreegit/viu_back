package com.viu.moduloautenticacion.Contract.Controller;

import com.viu.moduloautenticacion.Contract.Model.Contract;
import com.viu.moduloautenticacion.Contract.Service.ContractService;
import com.viu.moduloautenticacion.Parqueadero.model.Parking;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/contract")
@AllArgsConstructor
public class ContractController {
    private final ContractService contractService;

    @GetMapping("/findById/{id}")
    private ResponseEntity<Contract> findById(@PathVariable Long id){
        Optional<Contract> optContract = contractService.findById(id);
        if(optContract.isPresent()){
            ResponseEntity.ok(optContract.get());
        }
        return ResponseEntity.ok(new Contract());
    }

    @PostMapping("/save")
    private ResponseEntity<Contract> save(@RequestBody Contract contract){
        return ResponseEntity.ok(contractService.save(contract));
    }
}
