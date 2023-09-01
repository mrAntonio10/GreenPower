package com.upb.upb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j

@RestController
@RequestMapping("/green")
public class DemoController {
    @GetMapping
    public String test(){
        log.info("Ingresando a test");
        return "Hello World!!";
    }
}
