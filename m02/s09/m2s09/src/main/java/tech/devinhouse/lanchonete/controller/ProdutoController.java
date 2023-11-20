package tech.devinhouse.lanchonete.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.lanchonete.dto.ProdutoRequest;
import tech.devinhouse.lanchonete.dto.ProdutoResponse;
import tech.devinhouse.lanchonete.model.Produto;
import tech.devinhouse.lanchonete.service.ProdutoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Autowired
    private ModelMapper mapper;


    @GetMapping
    @RolesAllowed({"GERENTE","FUNCIONARIO","CLIENTE"})
    public ResponseEntity<List<ProdutoResponse>> consultar() {
        List<Produto> produtos = service.consultar();
        var resp = produtos.stream()
                .map(p -> mapper.map(p, ProdutoResponse.class)).toList();
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{codigo}")
    @RolesAllowed({"GERENTE","FUNCIONARIO","CLIENTE"})
    public ResponseEntity<ProdutoResponse> consultar(@PathVariable("codigo") Integer codigo) {
        var produto = service.consultar(codigo);
        var resp = mapper.map(produto, ProdutoResponse.class);
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    @RolesAllowed("GERENTE")
    public ResponseEntity<ProdutoResponse> criar(@RequestBody @Valid ProdutoRequest request) {
        Produto produto = mapper.map(request, Produto.class);
        produto = service.salvar(produto);
        var resp = mapper.map(produto, ProdutoResponse.class);
        return ResponseEntity.created(URI.create(produto.getCodigo().toString())).body(resp);
    }

    @PutMapping("{codigo}")
    @RolesAllowed("GERENTE")
    public ResponseEntity<ProdutoResponse> atualizar(@PathVariable("codigo") Integer codigo, @RequestBody @Valid ProdutoRequest request) {
        var produto = mapper.map(request, Produto.class);
        produto.setCodigo(codigo);
        produto = service.atualizar(produto);
        var resp = mapper.map(produto, ProdutoResponse.class);
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("{codigo}")
    @RolesAllowed("GERENTE")
    public ResponseEntity excluir(@PathVariable("codigo") Integer codigo) {
        service.excluir(codigo);
        return ResponseEntity.noContent().build();
    }

}
