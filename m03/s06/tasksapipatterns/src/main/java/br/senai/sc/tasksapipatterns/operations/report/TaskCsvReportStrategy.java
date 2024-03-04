package br.senai.sc.tasksapipatterns.operations.report;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskCsvReportStrategy implements TaskReportStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskCsvReportStrategy.class);

    @Override
    public void generate() {
        LOGGER.info("Generating CSV report for tasks...");
    }
}
