package br.senai.sc.apispringclient.client.feign;

import br.senai.sc.apispringclient.model.transport.operations.CreateTaskDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "tasks-client-service", url = "${tasks.api.url}", path = "/task")
public interface TasksFeignClientService {

    @GetMapping("/{id}")
    ResponseEntity<String> findTaskByGuid(@PathVariable("id") String id,
                                          @RequestHeader("Authorization") String authorization);

    @PostMapping
    ResponseEntity<String> createTask(@RequestHeader("Authorization") String authorization,
                                      @RequestBody CreateTaskDTO body);
}
