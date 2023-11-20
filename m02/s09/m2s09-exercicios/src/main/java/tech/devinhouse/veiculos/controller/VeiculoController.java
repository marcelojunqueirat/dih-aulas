package tech.devinhouse.veiculos.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.veiculos.dto.MultaRequest;
import tech.devinhouse.veiculos.dto.MultaResponse;
import tech.devinhouse.veiculos.dto.VeiculoRequest;
import tech.devinhouse.veiculos.dto.VeiculoResponse;
import tech.devinhouse.veiculos.model.*;
import tech.devinhouse.veiculos.service.UsuarioService;
import tech.devinhouse.veiculos.service.VeiculoService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    @RolesAllowed( {"ADMIN","USUARIO"} )
    public ResponseEntity<List<VeiculoResponse>> consultar() {
        var veiculos = veiculoService.consultar();
        var resp = new ArrayList<VeiculoResponse>();
        for (Veiculo veiculo : veiculos) {
            var veicDTO = mapper.map(veiculo, VeiculoResponse.class);
            if (veiculo.temMultas()) {
                var multasDTO = veiculo.getMultas().stream()
                        .map(m -> mapper.map(m, MultaResponse.class)).toList();
                veicDTO.setMultas(multasDTO);
            }
            resp.add(veicDTO);
        }
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{placa}")
    @RolesAllowed( {"ADMIN","USUARIO"} )
    public ResponseEntity<VeiculoResponse> consultar(@PathVariable("placa") String placa) {
        Veiculo veiculo = veiculoService.consultar(placa);
        var resp = mapper.map(veiculo, VeiculoResponse.class);
        if (veiculo.temMultas()) {
            var multasDTO = veiculo.getMultas().stream()
                    .map(m -> mapper.map(m, MultaResponse.class)).toList();
            resp.setMultas(multasDTO);
        }
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    @RolesAllowed("ADMIN")
    public ResponseEntity<VeiculoResponse> cadastrarVeiculo(@RequestBody @Valid VeiculoRequest request) {
        var veiculo = mapper.map(request, Veiculo.class);
        veiculo = veiculoService.salvar(veiculo);
        var resp = mapper.map(veiculo, VeiculoResponse.class);
        return ResponseEntity.created(URI.create(veiculo.getPlaca())).body(resp);
    }

    @PostMapping("/{placa}/multas")
    @RolesAllowed("ADMIN")
    public ResponseEntity<MultaResponse> cadastrarMulta(@PathVariable("placa") String placa,
                                                        @RequestBody @Valid MultaRequest request) {
        var multa = mapper.map(request, Multa.class);
        multa = veiculoService.cadastrarMulta(placa, multa);
        var resp = mapper.map(multa, MultaResponse.class);
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/dados")
    public ResponseEntity<?> carregarDados() {
        var veiculos = veiculoService.consultar();
        if (veiculos.isEmpty()) {
            Veiculo veiculo1 = new Veiculo("ABC-1234", TipoVeiculo.AUTOMOVEL, "Bat-Movel", 2022, "preto");
            Veiculo veiculo2 = new Veiculo("BCA-4321", TipoVeiculo.ONIBUS, "Enterprise", 1960, "prata");
            veiculoService.salvar(veiculo1);
            veiculoService.salvar(veiculo2);
            Multa multa1Veic1 = new Multa(veiculo1, "Farol apagado", "Gothan City", 250F);
            Multa multa2Veic1 = new Multa(veiculo1, "Insulfilm", "Gothan City", 100F);
            Multa multa1Veic2 = new Multa(veiculo2, "Excesso velocidade", "Hiper-espaço", 400F);
            veiculoService.cadastrarMulta(veiculo1.getPlaca(),multa1Veic1);
            veiculoService.cadastrarMulta(veiculo1.getPlaca(),multa2Veic1);
            veiculoService.cadastrarMulta(veiculo2.getPlaca(),multa1Veic2);
        }
        var usuarios = usuarioService.consultar();
        if (usuarios.isEmpty()) {
            usuarioService.inserir(new Usuario("James Kirk", "james@enterprise.com", "123456", Role.ADMIN));
            usuarioService.inserir(new Usuario("Spock", "spock@enterprise.com", "123456", Role.ADMIN));
            usuarioService.inserir(new Usuario("Leonard McCoy", "mccoy@enterprise.com", "123456", Role.USUARIO));
            usuarioService.inserir(new Usuario("Montgomery Scott", "scott@enterprise.com", "123456", Role.USUARIO));
        }
        return ResponseEntity.ok().build();
    }

}
