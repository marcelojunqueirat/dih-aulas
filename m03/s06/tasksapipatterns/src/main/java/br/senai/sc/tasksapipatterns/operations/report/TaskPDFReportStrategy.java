package br.senai.sc.tasksapipatterns.operations.report;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskPDFReportStrategy implements TaskReportStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskPDFReportStrategy.class);

    @Override
    public void generate() {
        LOGGER.info("Generating PDF report for tasks...");
    }
}
