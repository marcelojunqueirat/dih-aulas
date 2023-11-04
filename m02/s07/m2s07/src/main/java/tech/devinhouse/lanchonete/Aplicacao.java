package tech.devinhouse.lanchonete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.devinhouse.lanchonete.cli.LanchoneteUI;
import tech.devinhouse.lanchonete.model.*;
import tech.devinhouse.lanchonete.repository.ClienteRepository;
import tech.devinhouse.lanchonete.repository.PedidoRepository;
import tech.devinhouse.lanchonete.repository.ProdutoRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class Aplicacao {

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private ProdutoRepository produtoRepo;

    @Autowired
    private PedidoRepository pedidoRepo;

    @Autowired
    private LanchoneteUI ui;

    public void carregarDados() {
        List<Cliente> clientes = clienteRepo.findAll();
        if (clientes.isEmpty()) {
            clientes.add( new Cliente(11111111111L, "Obi-wan Kenobi") );
            clientes.add( new Cliente(22222222222L, "Ahsoka Tano") );
            clientes.add( new Cliente(33333333333L, "Luke Skywalker") );
            clientes.add( new Cliente(44444444444L, "Darth Vader") );
            clientes.add( new Cliente(55555555555L, "Lea") );
            clientes.add( new Cliente(66666666666L, "Yoda") );
            clienteRepo.saveAll(clientes);
        }
        List<Produto> produtos = produtoRepo.findAll();
        if (produtos.isEmpty()) {
            produtos.add( new Produto(1010, Categoria.LANCHE, "X-SALADA", 20.50F) );
            produtos.add( new Produto(1021, Categoria.LANCHE,  "X-BACON", 22.30F) );
            produtos.add( new Produto(1032, Categoria.LANCHE,  "X-TUDO", 40F) );
            produtos.add( new Produto(1055, Categoria.PIZZA,  "PORTUGUESA", 60F) );
            produtos.add( new Produto(1080, Categoria.PIZZA,  "CALABRESA", 62F) );
            produtos.add( new Produto(1034, Categoria.BEBIDA,  "REFRIGERANTE LATA", 6.50F) );
            produtos.add( new Produto(1040, Categoria.BEBIDA,  "SUCO", 7.25F) );
            produtoRepo.saveAll(produtos);
        }
        List<Pedido> pedidos = pedidoRepo.findAll();
        if (pedidos.isEmpty()) {
            Pedido pedido1 = new Pedido();
            Cliente luke = clientes.get(2);  // peguei o cliente que estava na posicao 2
            pedido1.setCliente(luke);
            Produto xbacon = produtos.get(1); // peguei o produto que estava na posicao 1
            pedido1.adicionar(xbacon, 2);
            Produto refri = produtos.get(5); // peguei o produto que estava na posicao 5
            pedido1.adicionar(refri, 3);
            pedidoRepo.save(pedido1);
            Pedido pedido2 = new Pedido();
            Cliente yoda = clientes.get(5);
            pedido2.setCliente(yoda);
            Produto pizzaCalabresa = produtos.get(4);
            pedido2.adicionar(pizzaCalabresa, 1);
            refri = produtos.get(5);
            pedido2.adicionar(refri, 1);
            pedidoRepo.save(pedido2);
        }
    }

    public void executar() {
        Operacao operacao;
        do {
            ui.mostrarMenu();
            try {
                operacao = ui.obterOperacao();
                processar(operacao);
            } catch (Exception e) {
                ui.exibirMensagemErro(e.getMessage());
                operacao = null;
            }
        } while (operacao != Operacao.SAIR);
    }

    private void processar(Operacao operacao) {
        if (operacao == Operacao.SAIR) {
            return;
        } else if (operacao == Operacao.LISTAR_PRODUTOS) {
            List<Produto> produtos = produtoRepo.findAll();
            ui.listar(produtos);
        } else if (operacao == Operacao.LISTAR_CLIENTES) {
            List<Cliente> clientes = clienteRepo.findAll();
            ui.listar(clientes);
        } else if (operacao == Operacao.LISTAR_PEDIDOS) {
            List<Pedido> pedidos = pedidoRepo.findAll();
            if (pedidos.isEmpty())
                ui.exibirMensagemErro("Sem pedidos cadastrados!");
            else
                ui.listar(pedidos);
        } else if (operacao == Operacao.CADASTRAR_PEDIDO) {
            Long cpf = ui.obterCpfCliente();
            // versao de localizar cliente usando explicitamente Optional e condicional
//            Optional<Cliente> clienteOpt = clienteRepo.findById(cpf);
//            if (clienteOpt.isEmpty()) {
//                throw new NoSuchElementException("CPF não encontrado: " + cpf));
//            }
            // versao de localizar cliente usando optional e jah lancando excecao caso nao exista
            Cliente cliente = clienteRepo.findById(cpf)
                    .orElseThrow(() -> new NoSuchElementException("CPF não encontrado: " + cpf));
            Pedido pedido = new Pedido();
            pedido.setCliente(cliente);
            boolean temMaisItensPraAdicionar;
            do {
                Integer codigoProduto = ui.obterProdutoDoPedido();
                Produto produto = produtoRepo.findById(codigoProduto)
                        .orElseThrow(() -> new NoSuchElementException("Codigo de Produto não encontrado: " + codigoProduto));
                Integer qtd = ui.obterQuantidadeDoProduto(produto);
                pedido.adicionar(produto, qtd);
                ui.exibirMensagemSucesso("Item adicionado!");
                temMaisItensPraAdicionar = ui.verificarNovoItem();
            } while (temMaisItensPraAdicionar);
            pedidoRepo.save(pedido);
            ui.exibirMensagemSucesso(String.format("Pedido cadastrado com sucesso! id = %d - Valor = R$ %.2f",
                    pedido.getId(), pedido.getValorTotal()));
        }

    }

    public void exemplos() {
        Cliente cliente = new Cliente();
        cliente.setCpf(55555555555L);
        cliente.setNome("Lea");
        // caso eu nao queira que altere um cliente já cadastrado
        Optional<Cliente> clienteOpt = clienteRepo.findById(cliente.getCpf());
        if (clienteOpt.isPresent()) {
            throw new RuntimeException("Cliente já cadastrado!");
        }
        clienteRepo.save(cliente);
//        boolean existe = clienteRepo.existsById(cliente.getCpf());
//        if (existe)
//            throw new RuntimeException("Cliente já cadastrado!");
//        Optional<Cliente> clienteOpt = clienteRepo.findByNome("Lea");
//        if (clienteOpt.isPresent())
//            throw new RuntimeException("Princesa Lea jah cadastrada!!!!");

//        Cliente cliente = clienteRepo.findById(99999999999L).get();
//        clienteRepo.delete(cliente);
//        clienteRepo.deleteById(cliente.getCpf()); // exclui pela chave primaria

//        Optional<Cliente> clienteOpt = clienteRepo.obterPorCpfENome(55555555555L, "Lea");
//        if (clienteOpt.isPresent())
//            System.out.println("ACHOU A PRINCESA LEAAAAAA!!!");

    }

}
