package tech.devinhouse.lanchonete;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import tech.devinhouse.lanchonete.model.*;
import tech.devinhouse.lanchonete.repository.ClienteRepository;
import tech.devinhouse.lanchonete.repository.PedidoRepository;
import tech.devinhouse.lanchonete.repository.ProdutoRepository;
import tech.devinhouse.lanchonete.service.UsuarioService;

import java.util.List;

@SpringBootApplication
public class M2s09Application {

	public static void main(String[] args) {
		SpringApplication.run(M2s09Application.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		var mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		return mapper;
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(ProdutoRepository produtoRepo, ClienteRepository clienteRepo,
						  PedidoRepository pedidoRepo, UsuarioService usuarioService) {
		return args -> {
			List<Produto> produtos = produtoRepo.findAll();
			if (produtos.isEmpty()) {
				produtos.add(new Produto(1010, Categoria.LANCHE, "X-SALADA", 20.50F));
				produtos.add(new Produto(1021, Categoria.LANCHE, "X-BACON", 22.30F));
				produtos.add(new Produto(1032, Categoria.LANCHE, "X-TUDO", 40F));
				produtos.add(new Produto(1055, Categoria.PIZZA, "PORTUGUESA", 60F));
				produtos.add(new Produto(1080, Categoria.PIZZA, "CALABRESA", 62F));
				produtos.add(new Produto(1034, Categoria.BEBIDAS, "REFRIGERANTE LATA", 6.50F));
				produtos.add(new Produto(1040, Categoria.BEBIDAS, "SUCO", 7.25F));
				produtoRepo.saveAll(produtos);
			}
			var clientes = clienteRepo.findAll();
			if (clientes.isEmpty()) {
				clientes.add(new Cliente(11111111111L, "Obi-wan Kenobi"));
				clientes.add(new Cliente(22222222222L, "Ahsoka Tano"));
				clientes.add(new Cliente(33333333333L, "Luke Skywalker"));
				clientes.add(new Cliente(44444444444L, "Darth Vader"));
				clientes.add(new Cliente(55555555555L, "Lea"));
				clientes.add(new Cliente(66666666666L, "Yoda"));
				clienteRepo.saveAll(clientes);
			}
			var pedidos = pedidoRepo.findAll();
			if (pedidos.isEmpty()) {
				Pedido pedido = new Pedido(clientes.get(0));
				pedido.adicionar(produtos.get(0), 2);
				pedido.adicionar(produtos.get(1), 3);
				pedidoRepo.save(pedido);
			}
			var usuarios = usuarioService.consultar();
			if (usuarios.isEmpty()) {
				usuarioService.inserir(new Usuario("James Kirk", "james@enterprise.com", "123456", Role.GERENTE));
				usuarioService.inserir(new Usuario("Spock", "spock@enterprise.com", "123456", Role.GERENTE));
				usuarioService.inserir(new Usuario("Leonard McCoy", "mccoy@enterprise.com", "123456", Role.FUNCIONARIO));
				usuarioService.inserir(new Usuario("Montgomery Scott", "scott@enterprise.com", "123456", Role.CLIENTE));
			}
		};
	}

}
