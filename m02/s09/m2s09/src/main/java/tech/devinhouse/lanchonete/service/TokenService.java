package tech.devinhouse.lanchonete.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tech.devinhouse.lanchonete.model.Usuario;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class TokenService {

    @Value("${secret}")  // busca a prop com esta chave no arquivo application.properties
    private String secret;

    /**
     * Recebe o bearer token completo que veio no Header Authorization
     * e retorna somente o token JWT
     */
    public String obterToken(String bearerToken) {
        final String bearer = "Bearer ";
        if (bearerToken == null || !bearerToken.startsWith(bearer))
            throw new JWTVerificationException("Invalid Authorization Header");
        String token = bearerToken.substring(bearer.length());
        return token;
    }

    /**
     * Recebe um token JWT como parametro, verifica se é um
     * token válido e se a assinatura confere, e então
     * retorna o 'subject' que está dentro do token
     */
    public String obterSubject(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret.getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);  // throws JWTVerificationException if not valid
        return decodedJWT.getSubject();
    }

    /**
     * Responsavel por receber um usuario e gerar um token JWT para o mesmo
     */
    public String gerarToken(Usuario usuario) {
        Algorithm algorithm = Algorithm.HMAC256(secret.getBytes());
        Instant expiration = gerarExpiracao(15);  // expiracao em x minutos
        String token = JWT.create()
                .withSubject(usuario.getEmail()) // sujeito - a quem pertence este token
                .withExpiresAt(expiration)  // data de expiracao
                .withIssuer("Lanchonete-API") // issuer = emissor do token
                .withClaim("roles", usuario.getRole().name())
                .sign(algorithm);  // assinar
        return token;
    }

    private Instant gerarExpiracao(int minutes) {
        return LocalDateTime.now().plusMinutes(minutes)
                .atZone(ZoneId.systemDefault()).toInstant();
    }

}
