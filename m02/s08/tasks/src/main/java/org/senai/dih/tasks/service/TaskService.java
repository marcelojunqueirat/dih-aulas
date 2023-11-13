package org.senai.dih.tasks.service;

import jakarta.transaction.Transactional;
import org.senai.dih.tasks.model.Assignee;
import org.senai.dih.tasks.model.Board;
import org.senai.dih.tasks.model.Task;
import org.senai.dih.tasks.model.transport.TaskDTO;
import org.senai.dih.tasks.model.transport.create.CreateTaskDTO;
import org.senai.dih.tasks.repository.AssigneeRepository;
import org.senai.dih.tasks.repository.BoardRepository;
import org.senai.dih.tasks.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);
    private final AssigneeRepository assigneeRepository;
    private final BoardRepository boardRepository;
    private final TaskRepository taskRepository;

    public TaskService(AssigneeRepository assigneeRepository, BoardRepository boardRepository, TaskRepository taskRepository) {
        this.assigneeRepository = assigneeRepository;
        this.boardRepository = boardRepository;
        this.taskRepository = taskRepository;
    }

    @Transactional
    public TaskDTO create(CreateTaskDTO createTaskDTO) {
        LOGGER.info("Iniciando o cadastro de uma nova tarefa...");
        Board board = this.boardRepository.findById(createTaskDTO.boardId())
                .orElseThrow(() -> new IllegalArgumentException("Board with following id is not found: " + createTaskDTO.boardId()));

        Assignee assignee = null;

        if (createTaskDTO.assigneeId() != null) {
            LOGGER.debug("O responsável foi informado. Recuperando informações...");
            assignee = this.assigneeRepository.findById(createTaskDTO.assigneeId())
                    .orElseThrow(() -> new IllegalArgumentException("Assignee with following id is not found: " + createTaskDTO.assigneeId()));
        }

        Task newTask = new Task(createTaskDTO, assignee, board);
        Task task = this.taskRepository.save(newTask);
        return new TaskDTO(task);
    }

    public Page<TaskDTO> list(Pageable pageable) {
        return this.taskRepository.findAll(pageable).map(TaskDTO::new);
    }

    @Transactional
    public TaskDTO update(Long id, CreateTaskDTO taskDTO) {
        Task task = this.taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task with id not found: " + id));

        Assignee assignee = this.assigneeRepository.findById(taskDTO.assigneeId())
                .orElseThrow(() -> new IllegalArgumentException("Assignee with id not found: " + id));

        task.setTitle(taskDTO.title());
        task.setDescription(taskDTO.description());
        task.setStatus(taskDTO.status());
        task.setFinishedAt(taskDTO.finishedAt());
        task.setAssignee(assignee);
        return new TaskDTO(task);
    }

    @Transactional
    public void delete(Long id) {
        this.taskRepository.deleteById(id);
    }

    public TaskDTO get(Long id) {
        return this.taskRepository.findById(id).map(TaskDTO::new).orElse(null);
    }
}
