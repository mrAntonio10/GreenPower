package com.upb.upb.controller;

import com.upb.upb.model.Arduino;
import com.upb.upb.model.dto.ArduinoDto;
import com.upb.upb.repository.ArduinoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j

@RestController
@RequestMapping("/green")
public class DemoController {
    @Autowired
    ArduinoRepository arduinoRepository;


    @GetMapping
    public String test(){
        log.info("Ingresando a test");
        return "Hello World!!";
    }

    @GetMapping("add-arduino")
    public String addArduino(){
        Arduino arduino = new Arduino();
        //el arduino debe de tener variables
        arduino.setSensor("Tipo1");
        arduino.setTemperatura(35.20);
        arduinoRepository.save(arduino);
        return "Agregando";
    }
}
