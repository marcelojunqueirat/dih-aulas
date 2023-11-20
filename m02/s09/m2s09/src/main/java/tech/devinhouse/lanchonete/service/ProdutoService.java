package tech.devinhouse.lanchonete.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.lanchonete.exception.RegistroJaExistenteException;
import tech.devinhouse.lanchonete.exception.RegistroNaoEncontradoException;
import tech.devinhouse.lanchonete.model.Produto;
import tech.devinhouse.lanchonete.repository.ProdutoRepository;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repo;

    @Autowired
    private ModelMapper mapper;


    public List<Produto> consultar() {
        return repo.findAll();
    }

    public Produto consultar(Integer codigo) {
        return repo.findById(codigo)
                .orElseThrow(() -> new RegistroNaoEncontradoException(Produto.class.getName(), codigo));
    }

    public Produto salvar(Produto produto) {
        boolean existe = repo.existsById(produto.getCodigo());
        if (existe)
            throw new RegistroJaExistenteException("Produto", produto.getCodigo());
        existe = repo.existsByDescricao(produto.getDescricao());
        if (existe)
            throw new RegistroJaExistenteException("Produto", produto.getDescricao());
        produto = repo.save(produto);
        return produto;
    }

    public Produto atualizar(Produto produtoDadosAlterados) {
        Produto produtoBD = repo.findById(produtoDadosAlterados.getCodigo())
                .orElseThrow(() -> new RegistroNaoEncontradoException("Produto", produtoDadosAlterados.getCodigo()));
        mapper.map(produtoDadosAlterados, produtoBD);
        produtoBD = repo.save(produtoBD);
        return produtoBD;
    }

    public void excluir(Integer codigo) {
        boolean existe = repo.existsById(codigo);
        if (!existe)
            throw new RegistroNaoEncontradoException("Produto", codigo);
        repo.deleteById(codigo);
    }

}
