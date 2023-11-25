package com.example.aula1.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="calc-feing",url = "http://localhost:8080/calc")
// Cria o bean e define as configurações do cliente HTTP
public interface CalculadoraFeign {

    @GetMapping
    Double getSoma();
}
