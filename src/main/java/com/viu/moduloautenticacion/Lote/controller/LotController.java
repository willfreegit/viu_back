package com.viu.moduloautenticacion.Lote.controller;

import com.viu.moduloautenticacion.Lote.model.Lot;
import com.viu.moduloautenticacion.Lote.service.LotService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/lot")
@AllArgsConstructor
public class LotController {

    private LotService lotService;

    @PostMapping("/save")
    public ResponseEntity<Lot> save(@RequestBody Lot lot){
        return ResponseEntity.ok(lotService.save(lot));
    }
}
