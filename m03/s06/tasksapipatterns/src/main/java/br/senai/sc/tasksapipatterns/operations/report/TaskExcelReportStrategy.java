package br.senai.sc.tasksapipatterns.operations.report;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskExcelReportStrategy implements TaskReportStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskExcelReportStrategy.class);

    @Override
    public void generate() {
        LOGGER.info("Generating Excel report for tasks...");
    }
}
