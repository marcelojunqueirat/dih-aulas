package br.senai.sc.tasksapipatterns.command;

import br.senai.sc.tasksapipatterns.model.transport.TaskDTO;

/**
 * Interface comum a todos os commands, para que sejam identificados como um
 */

public interface TaskCommand {

    TaskDTO execute(TaskDTO taskDTO) throws Exception;
}
