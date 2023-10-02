package com.upb.upb.rest;

import com.upb.upb.db.model.Arduino;
import com.upb.upb.db.service.ArduinoService;
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
@RequestMapping("/api/arduinos")
public class ArduinoController {
    @Autowired
    ArduinoService arduinoService;

    @GetMapping("")
    public ResponseEntity<List<Arduino>> arduinoFindAll(){
        try{
            log .info("Accediendo a listar todos los arduinos");
            return ok(arduinoService.findAll());
        } catch (Exception e){
            log.info("Error inesperado {}", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> plantaFindById(@PathVariable Long id) {
        try {
            log.info("Accediendo a listar arduino con id {}", id);
            return ok(arduinoService.findById(id));
        } catch (NoSuchElementException e) {
            log.info("Arduino no encontrado, message {}", e.getMessage());

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "Arduino con id " + id + " no encontrado");
            responseBody.put("status", HttpStatus.NOT_FOUND.value() + " " + HttpStatus.NOT_FOUND.getReasonPhrase());

            return ResponseEntity.badRequest().body(responseBody);
        } catch (Exception e) {
            log.info("Error inesperado {}", e);
            return ResponseEntity.badRequest().body("Error inesperado");
        }
    }

    @PostMapping("")
    ResponseEntity<Long> guardarPlanta(@RequestBody Arduino arduinoNuevo) {
        try {
            return ok(arduinoService.save(arduinoNuevo));
        }catch (Exception e){
            log.info("Error inesperado {}", e);

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "Error al guardar arduino");
            responseBody.put("status", HttpStatus.CONFLICT.value() + " " + HttpStatus.CONFLICT.getReasonPhrase());
            responseBody.put("catch", e);

            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("")
    ResponseEntity<?> modificarArduino(@RequestBody Arduino arduinoNuevo) {
        try {
            return ok(arduinoService.save(arduinoNuevo));
        } catch (NoSuchElementException e) {
            log.info("Arduino no encontrado, message {}", e.getMessage());

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "Arduino con id " + arduinoNuevo.getId() + " no encontrado");
            responseBody.put("status", HttpStatus.NOT_FOUND.value() + " " + HttpStatus.NOT_FOUND.getReasonPhrase());

            return ResponseEntity.badRequest().body(responseBody);
        } catch (Exception e) {
            log.info("Error inesperado {}", e);
            return ResponseEntity.badRequest().body("Error inesperado");
        }
    }
}
