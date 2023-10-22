package com.viu.moduloautenticacion.Lote.controller;

import com.viu.moduloautenticacion.Lote.model.Lot;
import com.viu.moduloautenticacion.Lote.service.LotService;
import com.viu.moduloautenticacion.Parqueadero.model.Parking;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/lot")
@AllArgsConstructor
public class LotController {

    private LotService lotService;

    @PostMapping("/save")
    public ResponseEntity<Lot> save(@RequestBody Lot lot){

        System.out.println("lot -----------------------> ");
        System.out.println(lot);
        return ResponseEntity.ok(lotService.save(lot));
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Lot> update(@PathVariable Long id, @RequestBody Lot lot){
        return ResponseEntity.ok(lotService.update(id, lot));
    }

    @PutMapping("/delete/{id}")
    private ResponseEntity<Lot> delete(@PathVariable Long id){
        return ResponseEntity.ok(lotService.delete(id));
    }

    @GetMapping("/getByParkingId/{id}")
    public ResponseEntity<List<Lot>> getByParkingId(@PathVariable long id){
        return ResponseEntity.ok(lotService.findByParkingId(id));
    }
}
