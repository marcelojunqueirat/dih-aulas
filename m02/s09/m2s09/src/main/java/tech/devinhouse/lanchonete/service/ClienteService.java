package tech.devinhouse.lanchonete.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.lanchonete.exception.RegistroJaExistenteException;
import tech.devinhouse.lanchonete.exception.RegistroNaoEncontradoException;
import tech.devinhouse.lanchonete.model.Cliente;
import tech.devinhouse.lanchonete.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    @Autowired
    private ModelMapper mapper;


    public List<Cliente> consultar() {
        return repo.findAll();
    }

    public Cliente consultar(Long cpf) {
        return repo.findById(cpf)
            .orElseThrow(() -> new RegistroNaoEncontradoException("Cliente", cpf));
    }

    public Cliente salvar(Cliente cliente) {
        boolean existe = repo.existsById(cliente.getCpf());
        if (existe)
            throw new RegistroJaExistenteException("Cliente", cliente.getCpf());
        cliente = repo.save(cliente);
        return cliente;
    }

    public Cliente atualizar(Cliente clienteDadosAlterados) {
        Cliente clienteBD = repo.findById(clienteDadosAlterados.getCpf())
                .orElseThrow(() -> new RegistroNaoEncontradoException(Cliente.class.getName(), clienteDadosAlterados.getCpf()));
        mapper.map(clienteDadosAlterados, clienteBD);
        clienteBD = repo.save(clienteBD);
        return clienteBD;
    }

    public void excluir(Long cpf) {
        boolean existe = repo.existsById(cpf);
        if (!existe)
            throw new RegistroNaoEncontradoException(Cliente.class.getName(), cpf);
        repo.deleteById(cpf);
    }

}

