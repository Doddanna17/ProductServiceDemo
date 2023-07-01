package com.doddanna.ProductService.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @RequestMapping("/liveness")
    public ResponseEntity<String> getHealthCheck(){
        return ResponseEntity.ok("OK");
    }

    @RequestMapping("/readiness")
    public ResponseEntity<String> getHealthOfReadiness(){
        return ResponseEntity.ok("OK");
    }

}
