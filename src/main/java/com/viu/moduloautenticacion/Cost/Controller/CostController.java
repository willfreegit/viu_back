package com.viu.moduloautenticacion.Cost.Controller;

import com.viu.moduloautenticacion.Cost.Model.Cost;
import com.viu.moduloautenticacion.Cost.Service.CostService;
import com.viu.moduloautenticacion.Lote.model.Lot;
import com.viu.moduloautenticacion.Parqueadero.model.Parking;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/cost")
@AllArgsConstructor
public class CostController {

    private final CostService costService;

    @GetMapping("/getByParkingId/{id}")
    public ResponseEntity<List<Cost>> getCostByParking(@PathVariable Long id){
        return ResponseEntity.ok(costService.findByParking(id));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Cost> getById(Long id){
        Optional<Cost> response = costService.findById(id);
        if(response.isPresent()){
            return ResponseEntity.ok(response.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<Cost> save(@RequestBody Cost cost){
        return ResponseEntity.ok(costService.save(cost));
    }
}
