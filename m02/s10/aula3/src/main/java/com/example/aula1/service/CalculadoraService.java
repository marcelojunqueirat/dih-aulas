package com.example.aula1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@Slf4j
public class CalculadoraService {

    public Double soma (Double v1, Double v2){
        log.info("Soma dos numero: " +v1+ "," +v2);
        return v2+v1;
    }
}
