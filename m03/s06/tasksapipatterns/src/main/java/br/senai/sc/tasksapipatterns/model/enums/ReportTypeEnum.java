package br.senai.sc.tasksapipatterns.model.enums;


import br.senai.sc.tasksapipatterns.exceptions.InvalidReportTypeException;
import br.senai.sc.tasksapipatterns.operations.report.TaskCsvReportStrategy;
import br.senai.sc.tasksapipatterns.operations.report.TaskExcelReportStrategy;
import br.senai.sc.tasksapipatterns.operations.report.TaskPDFReportStrategy;
import br.senai.sc.tasksapipatterns.operations.report.TaskReportStrategy;

import java.util.stream.Stream;

public enum ReportTypeEnum {

    PDF {
        @Override
        public TaskReportStrategy getReportStrategy() {
            return new TaskPDFReportStrategy();
        }
    },
    EXCEL {
        @Override
        public TaskReportStrategy getReportStrategy() {
            return new TaskExcelReportStrategy();
        }
    },
    CSV {
        @Override
        public TaskReportStrategy getReportStrategy() {
            return new TaskCsvReportStrategy();
        }
    };

    public static ReportTypeEnum getByType(String type) throws InvalidReportTypeException {
        return Stream.of(ReportTypeEnum.values())
                .filter(value -> value.name().equals(type.toUpperCase())).findFirst()
                .orElseThrow(() -> new InvalidReportTypeException("Report type is not valid: " + type));
    }

    public abstract TaskReportStrategy getReportStrategy();
}
