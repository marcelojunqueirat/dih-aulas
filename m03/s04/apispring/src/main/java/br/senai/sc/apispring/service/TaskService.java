package br.senai.sc.apispring.service;

import br.senai.sc.apispring.exceptions.PersonNotFoundException;
import br.senai.sc.apispring.exceptions.TaskNotFoundException;
import br.senai.sc.apispring.model.Person;
import br.senai.sc.apispring.model.Task;
import br.senai.sc.apispring.model.transport.TaskDTO;
import br.senai.sc.apispring.model.transport.operations.ApplyAssigneeDTO;
import br.senai.sc.apispring.model.transport.operations.CreateTaskDTO;
import br.senai.sc.apispring.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);
    private final TaskRepository taskRepository;
    private final PersonService personService;

    public TaskService(TaskRepository taskRepository, PersonService personService) {
        this.taskRepository = taskRepository;
        this.personService = personService;
    }

    public TaskDTO findByGuid(String guid) throws TaskNotFoundException {
        return this.taskRepository.findByTaskCompositeGuid(guid).map(TaskDTO::new)
                .orElseThrow(() -> new TaskNotFoundException("Tarefa não encontrada"));
    }


    @Transactional
    public TaskDTO create(CreateTaskDTO body, UserDetails userInSession) throws PersonNotFoundException {
        LOGGER.info("Iniciando a criação de uma tarefa para o usuário de e-mail: {}", userInSession.getUsername());
        Person person = this.personService.findByEmail(userInSession.getUsername());
        Task task = this.taskRepository.save(new Task(body, person));
        LOGGER.info("Usuário salvo, retornando-o...");
        return new TaskDTO(task);
    }

    @Transactional
    public TaskDTO applyAssignee(String id, ApplyAssigneeDTO body)
            throws TaskNotFoundException, PersonNotFoundException {

        Task task = this.taskRepository.findByTaskCompositeGuid(id)
                .orElseThrow(() -> new TaskNotFoundException("Tarefa não encontrada"));

        Person person = this.personService.findById(body.personId());
        task.getAssignees().add(person);
        return new TaskDTO(task);
    }
}
