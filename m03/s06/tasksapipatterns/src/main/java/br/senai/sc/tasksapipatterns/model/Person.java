package br.senai.sc.tasksapipatterns.model;

import br.senai.sc.tasksapipatterns.model.enums.NotificationTypeEnum;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
public class Person implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String guid;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "boolean DEFAULT true")
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationTypeEnum notificationType;

    @ManyToMany(mappedBy = "assignees")
    private Set<Assignment> assignments = new HashSet<>();

    public Person() {
    }

    public Person(String name, String email, String phone, String password, NotificationTypeEnum notificationType) {
        this.guid = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.enabled = true;
        this.notificationType = notificationType;
    }

    public void disable() {
        this.enabled = false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public NotificationTypeEnum getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationTypeEnum notificationType) {
        this.notificationType = notificationType;
    }

    public Set<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(Set<Assignment> assignments) {
        this.assignments = assignments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(guid, person.guid) && Objects.equals(name, person.name) && Objects.equals(email, person.email) && Objects.equals(phone, person.phone) && Objects.equals(password, person.password) && notificationType == person.notificationType && Objects.equals(assignments, person.assignments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, guid, name, email, phone, password, notificationType, assignments);
    }
}
