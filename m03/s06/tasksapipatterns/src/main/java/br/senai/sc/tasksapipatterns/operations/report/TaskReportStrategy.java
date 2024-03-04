package br.senai.sc.tasksapipatterns.operations.report;

/**
 * Uso do padrão strategy para lidar com diferentes tipos de
 * estratégia de implementação de relatórios
 */

public interface TaskReportStrategy {

    void generate();
}
