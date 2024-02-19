package br.senai.sc.apispringclient.client.http;

import br.senai.sc.apispringclient.exception.HttpRequestException;
import br.senai.sc.apispringclient.model.transport.PersonDTO;
import br.senai.sc.apispringclient.model.transport.operations.CreatePersonDTO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class TasksClientService {

    private final String url;
    private final Gson gson;

    public TasksClientService(@Value("${tasks.api.url}") String url) {
        this.url = url;
        this.gson = new Gson();
    }

    private String getAuthorizationHeader() {
        String username = "test@example.com";
        String password = "Teste@123";
        String authorization = String.format("%s:%s", username, password);
        return Base64.getEncoder().encodeToString(authorization.getBytes(StandardCharsets.UTF_8));
    }

    public PersonDTO findPersonByGuid(String id)
            throws URISyntaxException, IOException, InterruptedException, HttpRequestException {

        String authorizationHeader = this.getAuthorizationHeader();
        String requestUrl = String.format("%s/person/%s", this.url, id);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(requestUrl))
                .header("Authorization", "Basic " + authorizationHeader)
                .GET()
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new HttpRequestException(response.body());
        }

        return this.gson.fromJson(response.body(), PersonDTO.class);
    }

    public PersonDTO createPerson(CreatePersonDTO body)
            throws URISyntaxException, IOException, InterruptedException, HttpRequestException {
        String requestUrl = String.format("%s/person", this.url);
        String bodyAsJson = this.gson.toJson(body);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(requestUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(bodyAsJson))
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 201) {
            throw new HttpRequestException(response.body());
        }

        return this.gson.fromJson(response.body(), PersonDTO.class);
    }

}
