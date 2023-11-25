package com.example.aula1.service;

import com.example.aula1.dataprovider.Task;
import com.example.aula1.dataprovider.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // Traz a extensão do mockito
    // permite criar respostas pré definidas para algum método
class TaskServiceTest {

    @Mock // criando uma versão "fake" do taskRespository
    TaskRepository taskRepository;

    @InjectMocks // Recebe os Mocks
    TaskService taskService;

    @Test
    void getTaskTest() {
        List<Task> tasks = List.of(
                new Task(1L,"Titulo","Descricao",false));

        // quando eu chamar o métod (taskRepository.findAll()) então retorne o tasks
        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> resultado = taskService.getTask();

        assertNotNull(resultado); // Valida se o resultado não é null
        assertEquals(tasks.get(0).getTitulo(), resultado.get(0).getTitulo());
        // comparando o resultado com o valor que o mock colocou no retorno do banco de dados

    }

    @Test
    void saveTaskTest() {

        Task task = new Task(1L,"Titulo","Descricao",false);

        when(taskRepository.save(any())).thenReturn(task);

        Task resultado = taskService.saveTask(task);

        assertNotNull(resultado);
        assertEquals(task.getTitulo(), resultado.getTitulo());
    }
}