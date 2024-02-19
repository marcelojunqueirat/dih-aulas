package br.senai.sc.apispring.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    OpenAPI customOpenAPI() {
        License license = new License()
                .name("Apache 2.0")
                .url("");

        Info info = new Info()
                .title("Gerenciador de Tarefas - Clamed V2")
                .version("v1")
                .description("Projeto para gerenciamento de atividades na Clamed V2")
                .termsOfService("")
                .license(license);

        return new OpenAPI().info(info);
    }
}
