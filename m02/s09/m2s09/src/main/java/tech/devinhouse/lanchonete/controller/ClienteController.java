package tech.devinhouse.lanchonete.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.lanchonete.dto.ClienteRequest;
import tech.devinhouse.lanchonete.dto.ClienteResponse;
import tech.devinhouse.lanchonete.model.Cliente;
import tech.devinhouse.lanchonete.service.ClienteService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private ModelMapper mapper;


    @GetMapping
    @RolesAllowed({"GERENTE", "FUNCIONARIO"})
    public ResponseEntity<List<ClienteResponse>> consultar() {
        List<Cliente> clientes = service.consultar();
        List<ClienteResponse> resp = new ArrayList<>();
        for (Cliente cliente : clientes) {
            ClienteResponse r = mapper.map(cliente, ClienteResponse.class);
            resp.add(r);
        }
        // mesma coisa que acima
//        var resp = clientes.stream()
//                .map(c -> mapper.map(c, ClienteResponse.class)).toList();
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{cpf}")
    @RolesAllowed({"GERENTE", "FUNCIONARIO"})
    public ResponseEntity<ClienteResponse> consultar(@PathVariable("cpf") Long cpf) {
        Cliente cliente = service.consultar(cpf);
        ClienteResponse resp = mapper.map(cliente, ClienteResponse.class);
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    @RolesAllowed("GERENTE")
    public ResponseEntity<ClienteResponse> criar(@RequestBody @Valid ClienteRequest request) {
        var cliente = mapper.map(request, Cliente.class);
        cliente = service.salvar(cliente);
        var resp = mapper.map(cliente, ClienteResponse.class);
        return ResponseEntity.created(URI.create(cliente.getCpf().toString())).body(resp);
    }

    @PutMapping("{cpf}")
    @RolesAllowed("GERENTE")
    public ResponseEntity<ClienteResponse> atualizar(@PathVariable("cpf") Long cpf, @RequestBody @Valid ClienteRequest request) {
        var cliente = mapper.map(request, Cliente.class);
        cliente.setCpf(cpf);
        cliente = service.atualizar(cliente);
        var resp = mapper.map(cliente, ClienteResponse.class);
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("{cpf}")
    @RolesAllowed("GERENTE")
    public ResponseEntity excluir(@PathVariable("cpf") Long cpf) {
        service.excluir(cpf);
        return ResponseEntity.noContent().build();
    }

}
