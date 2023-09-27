package com.viu.moduloautenticacion.Rol.controlador;

import com.viu.moduloautenticacion.Rol.modelo.Rol;
import com.viu.moduloautenticacion.Rol.servicio.RolService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/rol")
@AllArgsConstructor
public class RolController {

    private final RolService rolService;
    @PostMapping("/save")
    public ResponseEntity<Rol> saveRol(@RequestBody Rol rol){
        return ResponseEntity.ok(rolService.saveRol(rol));
    }

    @GetMapping("/getRolById/{id}")
    public ResponseEntity<Rol> getRolByid(@PathVariable Long id){
        Optional<Rol> response = rolService.findById(id);
        if(response.isPresent()){
            return ResponseEntity.ok(response.get());
        }
        return ResponseEntity.notFound().build();
    }
}
