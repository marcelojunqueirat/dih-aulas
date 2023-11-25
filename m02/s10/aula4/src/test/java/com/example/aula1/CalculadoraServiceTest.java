package com.example.aula1;

import com.example.aula1.service.CalculadoraService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraServiceTest {


    @Test
    void soma() {

        CalculadoraService calculadoraService = new CalculadoraService();

        Double resultado = calculadoraService.soma(1.1,1.1);

        assertEquals(2.2, resultado);
    }

    // Task -> POST, GET
    // Repository, H2
    // Campos: Nome Task, Descricao Task, TaskCompleta (Boolean)
}