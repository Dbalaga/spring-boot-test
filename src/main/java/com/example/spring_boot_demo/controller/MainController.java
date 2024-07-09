package com.example.spring_boot_demo.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/test")
    public ResponseEntity<String> testService(){
        return new ResponseEntity<>("Application test successful...", HttpStatusCode.valueOf(200));
    }
}
