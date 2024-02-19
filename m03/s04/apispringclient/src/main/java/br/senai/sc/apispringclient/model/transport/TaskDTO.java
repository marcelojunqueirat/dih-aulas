package br.senai.sc.apispringclient.model.transport;

import br.senai.sc.apispringclient.model.enums.TaskStateEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Set;

public record TaskDTO(String guid,
                      String title,
                      String description,
                      TaskStateEnum status,
                      String createdAt,
                      String finishedAt,
                      PersonDTO owner,
                      Set<PersonDTO> assignees) {
}
