package com.example.aula1.controller;

import com.example.aula1.service.CalculadoraService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indica um controller e cria um Bean -> @Component; Spring MVC
@RequestMapping("calc") // Mapeia uma Requisição; Spring MVC
@RequiredArgsConstructor  // Lombok, construtor apenas com oq é final
public class CalculadoraController {

    private final CalculadoraService calculadoraService; // receber o valor do Bean CalculadoraService

    Logger logger = LoggerFactory.getLogger(CalculadoraController.class); // Logger é a classe de logs
    // Factory, cria um log para uma classe e especifico, nocaso CalculadoraController

    @GetMapping // Mapeamente do método GET; Spring MVC
    public Double calc(){
//        logger.warn("Warn calculo"); // Aparece sempre, denota possiveis erros no sistema
//
//        logger.debug("Debug calculo"); //denota pontos de debug
//        logger.trace("Trace calculo"); //denota um ponto onde queremos ver o log, mas não deve ocorrer em produção
//
//        logger.error("Error calculo");

        logger.info("Iniciando chamada de calculo"); // Aparece sempre, denota informações que ocorrem no sistema


        return calculadoraService.soma(1.5,1.0);
    }
}
