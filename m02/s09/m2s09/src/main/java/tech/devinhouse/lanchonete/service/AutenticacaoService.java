package tech.devinhouse.lanchonete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import tech.devinhouse.lanchonete.exception.AutenticacaoFalhaException;
import tech.devinhouse.lanchonete.exception.RegistroNaoEncontradoException;
import tech.devinhouse.lanchonete.model.Usuario;

import java.util.List;

@Service
public class AutenticacaoService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AuthenticationManager authenticationManager;


    public String autenticar(String email, String password) {
        try {
            var authToken = new UsernamePasswordAuthenticationToken(email, password);
            Authentication authenticate = authenticationManager.authenticate(authToken);
            var usuario  = (Usuario) authenticate.getPrincipal();
            String token = tokenService.gerarToken(usuario);
            return token;
        } catch (AuthenticationException e) {
            throw new AutenticacaoFalhaException("Invalid User or Password");
        }
    }

}
