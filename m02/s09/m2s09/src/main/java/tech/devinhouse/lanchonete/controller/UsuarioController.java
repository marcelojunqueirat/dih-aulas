package tech.devinhouse.lanchonete.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.lanchonete.dto.AutenticacaoRequest;
import tech.devinhouse.lanchonete.dto.AutenticacaoResponse;
import tech.devinhouse.lanchonete.dto.UsuarioRequest;
import tech.devinhouse.lanchonete.dto.UsuarioResponse;
import tech.devinhouse.lanchonete.model.Usuario;
import tech.devinhouse.lanchonete.service.AutenticacaoService;
import tech.devinhouse.lanchonete.service.UsuarioService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private ModelMapper mapper;


    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> consultar() {
        List<Usuario> usuarios = usuarioService.consultar();
        var resp = usuarios.stream().map(u -> mapper.map(u, UsuarioResponse.class)).toList();
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    @RolesAllowed("GERENTE")
    public ResponseEntity<UsuarioResponse> inserir(@RequestBody @Valid UsuarioRequest request) {
        Usuario usuario = mapper.map(request, Usuario.class);
        usuario = usuarioService.inserir(usuario);
        var resp = mapper.map(usuario, UsuarioResponse.class);
        return ResponseEntity.created(URI.create(usuario.getId().toString())).body(resp);
    }

    @PostMapping("/login")
    public ResponseEntity<AutenticacaoResponse> login(@RequestBody @Valid AutenticacaoRequest request) {
        var token = autenticacaoService.autenticar(request.getEmail(), request.getSenha());
        return ResponseEntity.ok(new AutenticacaoResponse(token));
    }

}
