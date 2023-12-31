package com.viu.moduloautenticacion.Parqueadero.controller;

import com.viu.moduloautenticacion.Parqueadero.model.Parking;
import com.viu.moduloautenticacion.Parqueadero.service.ParkingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/parking")
public class ParkingController {

    private final ParkingService parkingService;
    @PostMapping("/save")
    private ResponseEntity<Parking> save(@RequestBody Parking parking){
        return ResponseEntity.ok(parkingService.save(parking));
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Parking> update(@PathVariable Long id, @RequestBody Parking parking){
        return ResponseEntity.ok(parkingService.update(id, parking));
    }

    @GetMapping("/getById/{id}")
    private ResponseEntity<Parking> getById(@PathVariable Long id){
        Optional<Parking> response = parkingService.findById(id);
        if(response.isPresent()){
            return ResponseEntity.ok(response.get());
        }
        return ResponseEntity.notFound().build();
    }
}
