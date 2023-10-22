package com.viu.moduloautenticacion.Lote.service;

import com.viu.moduloautenticacion.Contract.Model.Contract;
import com.viu.moduloautenticacion.Contract.Service.ContractService;
import com.viu.moduloautenticacion.Lote.model.Lot;
import com.viu.moduloautenticacion.Lote.repository.LotRepository;
import com.viu.moduloautenticacion.Parqueadero.model.Parking;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LotServiceImp implements LotService {

    private final LotRepository lotRepository;
    private final ContractService contractService;


    @Override
    public Lot save(Lot lot) {
        return lotRepository.save(lot);
    }

    @Override
    public Lot update(Long id, Lot parking) {
        Optional<Lot> parkingOptional = lotRepository.findById(id);
        if(parkingOptional.isPresent()){
            Lot old = parkingOptional.get();
            old.setCode(parking.getCode());
            old.setState(parking.getState());
            old.setType(parking.getType());
            return lotRepository.save(old);
        }
        return null;
    }

    @Override
    public List<Lot> findByParkingId(long id) {
        List<Lot> lots = lotRepository.findByParkingId(id);
        for (int i=0; i < lots.size(); i++){
            List<Contract> contracts = contractService.findByLotId(lots.get(i).getId_lot());
            if(contracts != null && !contracts.isEmpty()){
                List<Contract> current = contracts.stream().filter(x -> x.getState().equals("VIGENTE")).collect(Collectors.toList());
                if(current != null && !current.isEmpty()){
                    lots.get(i).setContract_id(current.get(0).getId_contract() + "");
                    lots.get(i).setContract_register(current.get(0).getRegister());
                }
            }
        }
        return lots;
    }

    @Override
    public Lot delete(Long id) {
        Optional<Lot> parkingOptional = lotRepository.findById(id);
        if(parkingOptional.isPresent()){
            Lot old = parkingOptional.get();
            old.setDeleted("1");
            System.out.println("si elimina...." + id);
            return lotRepository.save(old);
        }
        return null;
    }
}
