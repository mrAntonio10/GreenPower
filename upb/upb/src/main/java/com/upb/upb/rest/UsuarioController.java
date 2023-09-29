package com.upb.upb.rest;

import com.upb.upb.db.model.Usuario;
import com.upb.upb.db.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("")
    public ResponseEntity<List<Usuario>> usuarioFindAll(){
        try{
            log .info("Accediendo a listar todas las bitacoras");
            return ok(usuarioService.findAll());
        } catch (Exception e){
            log.info("Error inesperado {}", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("")
    ResponseEntity<Long> guardarUsuario(@RequestBody Usuario usuarioNuevo) {
        try {
            return ok(usuarioService.save(usuarioNuevo));
        }catch (Exception e){
            log.info("Error inesperado {}", e);

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "Error al guardar usuario");
            responseBody.put("status", HttpStatus.CONFLICT.value() + " " + HttpStatus.CONFLICT.getReasonPhrase());
            responseBody.put("catch", e);

            return ResponseEntity.badRequest().body(null);
        }
    }
}
