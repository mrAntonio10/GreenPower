package com.upb.upb.rest;

import com.upb.upb.db.model.Vivero_arduino_planta;
import com.upb.upb.db.service.ViveroArduinoPlantaService;
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
@RequestMapping("/api/vaps")
public class ViveroArduinoPlantaController {
    @Autowired
    ViveroArduinoPlantaService vapService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Vivero_arduino_planta>> vapFindAll(@PathVariable Long id){
        try{
            log .info("Accediendo a listar todos los vaps");
            return ok(vapService.findAllByViveroId(id));
        } catch (Exception e){
            log.info("Error inesperado {}", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/plantas/{id}")
    public ResponseEntity<?> vapFindPlantasByIdVivero(@PathVariable Long id) {
        try {
            log.info("Accediendo a listar plantas con vivero id {}", id);
            return ok(vapService.findAllPlantaByViveroId(id));
        } catch (NoSuchElementException e) {
            log.info("Datos no encontrados, message {}", e.getMessage());

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "Plantas con vivero id " + id + " no encontrado");
            responseBody.put("status", HttpStatus.NOT_FOUND.value() + " " + HttpStatus.NOT_FOUND.getReasonPhrase());

            return ResponseEntity.badRequest().body(responseBody);
        } catch (Exception e) {
            log.info("Error inesperado {}", e);
            return ResponseEntity.badRequest().body("Error inesperado");
        }
    }

    @GetMapping("/arduinos/{id}")
    public ResponseEntity<?> vapFindArduinosByIdVivero(@PathVariable Long id) {
        try {
            log.info("Accediendo a listar arduinos con vivero id {}", id);
            return ok(vapService.findAllArduinoByViveroId(id));
        } catch (NoSuchElementException e) {
            log.info("Datos no encontrados, message {}", e.getMessage());

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "Datos arduino con vivero id " + id + " no encontrado");
            responseBody.put("status", HttpStatus.NOT_FOUND.value() + " " + HttpStatus.NOT_FOUND.getReasonPhrase());

            return ResponseEntity.badRequest().body(responseBody);
        } catch (Exception e) {
            log.info("Error inesperado {}", e);
            return ResponseEntity.badRequest().body("Error inesperado");
        }
    }

    @PostMapping("")
    ResponseEntity<Long> guardarVap(@RequestBody Vivero_arduino_planta vapNuevo) {
        try {
            return ok(vapService.save(vapNuevo));
        }catch (Exception e){
            log.info("Error inesperado {}", e);

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "Error al guardar nueva relacion ViveroArduinoPlanta");
            responseBody.put("status", HttpStatus.CONFLICT.value() + " " + HttpStatus.CONFLICT.getReasonPhrase());
            responseBody.put("catch", e);

            return ResponseEntity.badRequest().body(null);
        }
    }
}
