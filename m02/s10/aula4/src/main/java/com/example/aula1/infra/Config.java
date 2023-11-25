package com.example.aula1.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//
//@Configuration // ele é carregado no contexto do Spring pelo @EnableAutoConfiguration que está dentro do @SpringBootApplication
//// denota uma classe que contém beans
//public class Config {
//
//    @Bean // Configuração de uma instanciação de uma classe
//    // Essa instancia é usada pelo programa completo
//    // Patter Singleton, onde apenas uma instancaia de uma classe é usada
//    public CalculadoraService calculadoraService(){
//        return new CalculadoraService();
//    }
//
//    @Bean
//    public CalculadorController calculadorController(){
//        return new CalculadorController(calculadoraService());
//    }
//}
