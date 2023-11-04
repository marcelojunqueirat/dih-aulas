package tech.devinhouse.personagem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class M2s07PersonagemApplication {

	private Aplicacao aplicacao;

	public static void main(String[] args) {
		SpringApplication.run(M2s07PersonagemApplication.class, args);
	}

	@Bean
	CommandLineRunner run(Aplicacao aplicacao) {
		return args -> {
			aplicacao.executar();
		};
	}

}
