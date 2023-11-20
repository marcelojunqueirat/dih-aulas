package tech.devinhouse.lanchonete.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.lanchonete.exception.RegistroNaoEncontradoException;
import tech.devinhouse.lanchonete.model.Cliente;
import tech.devinhouse.lanchonete.model.ItemPedido;
import tech.devinhouse.lanchonete.model.Pedido;
import tech.devinhouse.lanchonete.model.Produto;
import tech.devinhouse.lanchonete.repository.PedidoRepository;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ModelMapper mapper;


    public List<Pedido> consultar() {
        return repo.findAll();
    }

    public Pedido salvar(Pedido pedido) {
        Cliente cliente = clienteService.consultar(pedido.getCliente().getCpf());
        var pedidoNovo = new Pedido(cliente);  // cliente com todos os dados instanciados (managed)
        for (ItemPedido item : pedido.getItens()) {
            Produto produto = produtoService.consultar(item.getCodigoProduto());
            pedidoNovo.adicionar(produto, item.getQuantidade());
        }
        pedidoNovo = repo.save(pedidoNovo);
        return pedidoNovo;
    }

    public void excluir(Integer id) {
        boolean existe = repo.existsById(id);
        if (!existe)
            throw new RegistroNaoEncontradoException(Pedido.class.getName(), id);
        repo.deleteById(id);
    }

}
