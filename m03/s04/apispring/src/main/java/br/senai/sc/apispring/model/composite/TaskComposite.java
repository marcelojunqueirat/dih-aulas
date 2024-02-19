package br.senai.sc.apispring.model.composite;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TaskComposite implements Serializable {

    private String guid;
    private String title;

    public TaskComposite() {

    }

    public TaskComposite(String guid, String title) {
        this.guid = guid;
        this.title = title;
    }

    public String getGuid() {
        return guid;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskComposite that = (TaskComposite) o;
        return Objects.equals(guid, that.guid) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, title);
    }
}
