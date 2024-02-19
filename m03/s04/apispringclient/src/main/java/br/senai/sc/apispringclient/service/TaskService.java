package br.senai.sc.apispringclient.service;

import br.senai.sc.apispringclient.client.feign.TasksFeignClientService;
import br.senai.sc.apispringclient.exception.HttpRequestException;
import br.senai.sc.apispringclient.model.transport.TaskDTO;
import br.senai.sc.apispringclient.model.transport.operations.CreateTaskDTO;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class TaskService {

    private final TasksFeignClientService clientService;
    private final Gson gson;

    public TaskService(TasksFeignClientService clientService) {
        this.clientService = clientService;
        this.gson = new Gson();
    }

    private String getAuthorizationHeader() {
        String username = "test@example.com";
        String password = "Teste@123";
        String authorization = String.format("%s:%s", username, password);
        return "Basic " + Base64.getEncoder().encodeToString(authorization.getBytes(StandardCharsets.UTF_8));
    }

    public TaskDTO getTaskByGuid(String id) throws HttpRequestException {
        String authorizationHeader = this.getAuthorizationHeader();
        ResponseEntity<String> response = this.clientService
                .findTaskByGuid(id, authorizationHeader);

        if (response.getStatusCode().is2xxSuccessful()) {
            return this.gson.fromJson(response.getBody(), TaskDTO.class);
        }

        throw new HttpRequestException(response.getBody());
    }

    public TaskDTO create(CreateTaskDTO body) throws HttpRequestException {
        String authorizationHeader = this.getAuthorizationHeader();
        ResponseEntity<String> response = this.clientService.createTask(authorizationHeader, body);

        if (response.getStatusCode().is2xxSuccessful()) {
            return this.gson.fromJson(response.getBody(), TaskDTO.class);
        }
        throw new HttpRequestException(response.getBody());
    }
}
