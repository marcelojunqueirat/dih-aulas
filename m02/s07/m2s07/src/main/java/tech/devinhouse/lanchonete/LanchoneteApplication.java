package tech.devinhouse.lanchonete;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LanchoneteApplication {

	public static void main(String[] args) {
		SpringApplication.run(LanchoneteApplication.class, args);
	}

	@Bean
	CommandLineRunner run(Aplicacao app) {
		return args -> {
			app.carregarDados();
			app.executar();
//			app.exemplos();
		};
	}

}
