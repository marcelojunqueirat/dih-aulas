package br.senai.sc.apispring.model;

import br.senai.sc.apispring.model.composite.PersonComposite;
import br.senai.sc.apispring.model.transport.operations.CreatePersonDTO;
import jakarta.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@IdClass(PersonComposite.class)
public class Person implements UserDetails {

    @Id
    @Column(nullable = false, length = 36, unique = true)
    private String guid;

    @Id
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    private LocalDateTime createdAt;

    private boolean enabled;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    private ResidenceAddress address;

    @ManyToMany(mappedBy = "assignees")
    private Set<Task> tasks = new HashSet<>();

    public Person() {

    }

    public Person(CreatePersonDTO createPersonDTO, String password) {
        this.guid = UUID.randomUUID().toString();
        this.email = createPersonDTO.email();
        this.name = createPersonDTO.name();
        this.password = password;
        this.createdAt = LocalDateTime.now();
        this.enabled = true;
        this.address = new ResidenceAddress(createPersonDTO.address());
    }

    public String getGuid() {
        return guid;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public ResidenceAddress getAddress() {
        return address;
    }

    public Set<Task> getTasks() {
        return tasks;
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
}
