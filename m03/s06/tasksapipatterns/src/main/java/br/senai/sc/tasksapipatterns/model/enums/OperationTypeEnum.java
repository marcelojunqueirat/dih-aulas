package br.senai.sc.tasksapipatterns.model.enums;

public enum OperationTypeEnum {
    DISABLED_USER("Disable the user account"),
    GENERATE_REPORT("Generate assignments report"),
    CREATE_ASSIGNMENT("Create new assignment"),
    DELETE_ASSIGNMENT("Delete a specific assigment"),
    APPLY_ASSIGNEE("Add new colaborator on assignment");

    private final String description;

    OperationTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
