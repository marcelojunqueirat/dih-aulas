package br.senai.sc.tasksapitests.service;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<String> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    public String add(String user) throws Exception {
        if (users.contains(user)) {
            throw new Exception("User already exists");
        }
        this.users.add(user);
        return user;
    }

    public void remove(String user) throws Exception {
        if (!users.contains(user)) {
            throw new Exception("User does not exists");
        }
        this.users.remove(user);
    }

    public String update(String oldUser, String newUser) throws Exception {
        if (!this.users.contains(oldUser)) {
            throw new Exception("Usuário não encontrado");
        }

        if (this.users.contains(newUser)) {
            throw new Exception("Usuário já existe na base");
        }

        this.users.remove(oldUser);
        this.users.add(newUser);
        return newUser;
    }

    public List<String> getUsers() {
        return users;
    }
}
