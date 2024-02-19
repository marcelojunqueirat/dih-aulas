package br.senai.sc.apispring.model.composite;

import java.io.Serializable;
import java.util.Objects;

public class PersonComposite implements Serializable {

    private String guid;
    private String email;

    public PersonComposite() {

    }

    public PersonComposite(String guid, String email) {
        this.guid = guid;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonComposite that = (PersonComposite) o;
        return Objects.equals(guid, that.guid) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, email);
    }
}
