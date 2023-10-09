package com.upb.upb.rest;

import com.upb.upb.db.model.Planta;
import com.upb.upb.db.service.PlantaService;
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
@RequestMapping("/api/plantas")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class PlantaController {
    @Autowired
    PlantaService plantaService;

    @GetMapping("")
    public ResponseEntity<List<Planta>> plantaFindAll(){
        try{
            log .info("Accediendo a listar todas las plantas");
            return ok(plantaService.findAll());
        } catch (Exception e){
            log.info("Error inesperado {}", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> plantaFindById(@PathVariable Long id) {
        try {
            log.info("Accediendo a listar planta con id {}", id);
            return ok(plantaService.findById(id));
        } catch (NoSuchElementException e) {
            log.info("Planta no encontrado, message {}", e.getMessage());

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "Planta con id " + id + " no encontrado");
            responseBody.put("status", HttpStatus.NOT_FOUND.value() + " " + HttpStatus.NOT_FOUND.getReasonPhrase());

            return ResponseEntity.badRequest().body(responseBody);
        } catch (Exception e) {
            log.info("Error inesperado {}", e);
            return ResponseEntity.badRequest().body("Error inesperado");
        }
    }

    @PostMapping("")
    ResponseEntity<?> guardarPlanta(@RequestBody Planta plantaNueva) {
        try {
            return ok(plantaService.save(plantaNueva));
        } catch (NoSuchElementException e) {
            log.info("Planta no encontrado, message {}", e.getMessage());

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "Planta con id " + plantaNueva.getId() + " no encontrado");
            responseBody.put("status", HttpStatus.NOT_FOUND.value() + " " + HttpStatus.NOT_FOUND.getReasonPhrase());

            return ResponseEntity.badRequest().body(responseBody);
        } catch (Exception e) {
            log.info("Error inesperado {}", e);
            return ResponseEntity.badRequest().body("Error inesperado");
        }
    }

    @PutMapping("")
    ResponseEntity<?> modificarPlanta(@RequestBody Planta plantaNueva) {
        try {
            return ok(plantaService.save(plantaNueva));
        } catch (NoSuchElementException e) {
            log.info("Planta no encontrado, message {}", e.getMessage());

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "Planta con id " + plantaNueva.getId() + " no encontrado");
            responseBody.put("status", HttpStatus.NOT_FOUND.value() + " " + HttpStatus.NOT_FOUND.getReasonPhrase());

            return ResponseEntity.badRequest().body(responseBody);
        } catch (Exception e) {
            log.info("Error inesperado {}", e);
            return ResponseEntity.badRequest().body("Error inesperado");
        }
    }
}
