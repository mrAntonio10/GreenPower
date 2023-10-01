package com.upb.upb.rest;

import com.upb.upb.db.model.Vivero;
import com.upb.upb.db.service.ViveroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequestMapping("/api/vivero")
public class ViveroController {
    @Autowired
    ViveroService viveroService;

    @GetMapping("")
    public ResponseEntity<List<Vivero>> usuarioFindAll() {
        try {
            log.info("Accediendo lista de usuarios");
            return ok(viveroService.findAll());
        } catch (Exception e) {
            log.info("Error inesperado {}", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> usuarioFindById(@PathVariable Long id) {
        try {
            log.info("Accediendo a listar usuario con id {}", id);
            return ok(viveroService.findById(id));
        } catch (NoSuchElementException e) {
            log.info("Usuario no encontrado, message {}", e.getMessage());

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "Usuario con id " + id + " no encontrado");
            responseBody.put("status", HttpStatus.NOT_FOUND.value() + " " + HttpStatus.NOT_FOUND.getReasonPhrase());

            return ResponseEntity.badRequest().body(responseBody);
        } catch (Exception e) {
            log.info("Error inesperado {}", e);
            return ResponseEntity.badRequest().body("Error inesperado");
        }
    }

    @PostMapping("")
    ResponseEntity<Long> guardarVivero(@RequestBody Vivero viveroNuevo) {
        try {
            return ok(viveroService.save(viveroNuevo));
        } catch (Exception e) {
            log.info("Error inesperado {}", e);
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "No se pudo guardar el usuario, error inesperado");
            responseBody.put("status", HttpStatus.CONFLICT.value() + " " + HttpStatus.CONFLICT.getReasonPhrase());
            return ResponseEntity.badRequest().body(null);
        }
    }
}
