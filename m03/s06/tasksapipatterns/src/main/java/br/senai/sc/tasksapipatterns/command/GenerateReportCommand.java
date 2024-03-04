package br.senai.sc.tasksapipatterns.command;

import br.senai.sc.tasksapipatterns.model.enums.ReportTypeEnum;
import br.senai.sc.tasksapipatterns.model.transport.TaskDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Lazy
@Component
public class GenerateReportCommand implements TaskCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateReportCommand.class);

    @Override
    @Transactional
    public TaskDTO execute(TaskDTO taskDTO) throws Exception {
        LOGGER.info("Starting generating assignments report...");
        String type = taskDTO.getMetadata();
        ReportTypeEnum.getByType(type).getReportStrategy().generate();
        return taskDTO;
    }
}
