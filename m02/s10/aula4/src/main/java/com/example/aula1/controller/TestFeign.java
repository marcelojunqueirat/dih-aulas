package com.example.aula1.controller;

import com.example.aula1.dataprovider.Task;
import com.example.aula1.gateway.CalculadoraFeign;
import com.example.aula1.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("feign")
@RequiredArgsConstructor
public class TestFeign {
    private final CalculadoraFeign calculadoraFeign;

    @GetMapping
    public ResponseEntity<Double> getTasks(){

        return ResponseEntity.ok(calculadoraFeign.getSoma());
    }
}
