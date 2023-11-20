package tech.devinhouse.lanchonete.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.lanchonete.dto.ItemRequest;
import tech.devinhouse.lanchonete.dto.PedidoRequest;
import tech.devinhouse.lanchonete.dto.PedidoResponse;
import tech.devinhouse.lanchonete.model.Cliente;
import tech.devinhouse.lanchonete.model.Pedido;
import tech.devinhouse.lanchonete.service.PedidoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @Autowired
    private ModelMapper mapper;


    @GetMapping
    @RolesAllowed({"GERENTE","FUNCIONARIO"})
    public ResponseEntity<List<PedidoResponse>> consultar() {
        List<Pedido> pedidos = service.consultar();
        //TODO: configurar para fazer mapeamento com ModelMapper
        var resp = pedidos.stream().map(pedido -> new PedidoResponse(pedido.getId(),
                pedido.getDataPedido(), pedido.getCliente().getCpf(), pedido.getValorTotal(),
                pedido.getItens())).toList();
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    @RolesAllowed({"GERENTE","FUNCIONARIO","CLIENTE"})
    public ResponseEntity<PedidoResponse> criar(@RequestBody @Valid PedidoRequest request) {
        var pedido = new Pedido();
        pedido.setCliente(new Cliente(request.getCpf()));
        for (ItemRequest itemReq : request.getItens()) {
           pedido.adicionar(itemReq.getCodigoProduto(), itemReq.getQuantidade());
        }
        pedido = service.salvar(pedido);
        var resp = new PedidoResponse(pedido.getId(), pedido.getDataPedido(),
                pedido.getCliente().getCpf(), pedido.getValorTotal(), pedido.getItens());
        return ResponseEntity.created(URI.create(pedido.getId().toString())).body(resp);
    }

    @DeleteMapping("{id}")
    @RolesAllowed("GERENTE")
    public ResponseEntity excluir(@PathVariable("id") Integer id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
