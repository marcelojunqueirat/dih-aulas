package br.senai.sc.tasksapipatterns.model.operations;

public class ApplyAssigneeForm {

    private String userIdentifier;
    private String assignmentIdentifier;

    public ApplyAssigneeForm(String userIdentifier, String assignmentIdentifier) {
        this.userIdentifier = userIdentifier;
        this.assignmentIdentifier = assignmentIdentifier;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public String getAssignmentIdentifier() {
        return assignmentIdentifier;
    }

    public void setAssignmentIdentifier(String assignmentIdentifier) {
        this.assignmentIdentifier = assignmentIdentifier;
    }
}
