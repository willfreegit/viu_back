package com.viu.moduloautenticacion.Usuario.controlador;

import com.viu.moduloautenticacion.Usuario.modelo.Usuario;
import com.viu.moduloautenticacion.Usuario.servicio.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    @PostMapping("/save")
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.saveUsuario(usuario));
    }

    @GetMapping("/getUsuarioById/{id}")
    public ResponseEntity<Usuario> getUsuarioByid(@PathVariable Long id){
        Optional<Usuario> response = usuarioService.findById(id);
        if(response.isPresent()){
            return ResponseEntity.ok(response.get());
        }
        return ResponseEntity.notFound().build();
    }

}
