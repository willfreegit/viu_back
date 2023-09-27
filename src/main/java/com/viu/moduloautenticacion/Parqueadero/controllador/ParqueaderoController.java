package com.viu.moduloautenticacion.Parqueadero.controllador;

import com.viu.moduloautenticacion.Parqueadero.modelo.Parqueadero;
import com.viu.moduloautenticacion.Parqueadero.servicio.ParqueaderoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/parking")
public class ParqueaderoController {

    private final ParqueaderoService parqueaderoService;
    @PostMapping("/save")
    private ResponseEntity<Parqueadero> save(@RequestBody Parqueadero parqueadero){
        return ResponseEntity.ok(parqueaderoService.save(parqueadero));
    }
}
