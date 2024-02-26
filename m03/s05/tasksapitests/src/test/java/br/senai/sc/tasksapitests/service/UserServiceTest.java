package br.senai.sc.tasksapitests.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setup() {
        this.userService = new UserService();
    }

    @Test
    void addUserWhenAlreadyExistsThrowsException() throws Exception {
        String user = "User 01";
        this.userService.add(user);
        Assertions.assertThrows(Exception.class, () -> this.userService.add(user));
    }

    @Test
    void addUserReturnsSuccess() {
        Assertions.assertDoesNotThrow(() -> this.userService.add("User 01"));
    }

    @Test
    void addUserReturnsCreatedUser() throws Exception {
        String user = "User 01";
        String createdUser = this.userService.add(user);
        Assertions.assertEquals(user, createdUser);
    }

    /*
     * EDITAR USUÁRIO:
     *
     * 1. BUSCA O USUÁRIO QUE SE DESEJA ALTERAR;
     * 1.1. SE O USUÁRIO NÃO EXISTIR, DEVEMOS LANÇAR UM ERRO;
     *
     * 2. CASO O "NOVO" USUÁRIO JÁ EXISTA, ENTÃO LANCE UM ERRO;
     *
     * 3. UMA VEZ ENCONTRADO O USUÁRIO, REMOVA-O DA LISTA DE USUÁRIOS;
     *
     * 4. ADICIONE O "NOVO" USUÁRIO, QUE SUBSTITUI O ANTERIOR;
     *
     * */

    @Test
    void getUserToUpdateReturnsSuccess() throws Exception {
        String oldUser = "User 01";
        this.userService.add(oldUser);

        String updatedUser = "User 02";

        Assertions.assertDoesNotThrow(() -> this.userService
                .update(oldUser, updatedUser), "Usuário não encontrado");
    }

    @Test
    void getUserToUpdateReturnsErrorBecauseUserDoesNotExist() {
        String oldUser = "User 01";
        String updatedUser = "User 02";

        Assertions.assertThrows(Exception.class, () -> this.userService
                .update(oldUser, updatedUser), "Usuário não encontrado");
    }

    @Test
    void ifNewUserNameExistsThrowException() throws Exception {
        String oldUser = "User 01";
        String updatedUser = "User 02";

        this.userService.add(oldUser);
        this.userService.add(updatedUser);

        Assertions.assertThrows(Exception.class, () -> this.userService
                .update(oldUser, updatedUser), "Usuário já existe na base");
    }

    @Test
    void ifOldUserIsFoundRemoveIt() throws Exception {
        String oldUser = "User 01";
        String updatedUser = "User 02";

        this.userService.add(oldUser);
        this.userService.update(oldUser, updatedUser);
        Assertions.assertFalse(this.userService.getUsers().contains(oldUser));
    }

    @Test
    void updateUserChangeUserNameAndReturnIt() throws Exception {
        String oldUser = "User 01";
        String updatedUser = "User 02";

        this.userService.add(oldUser);
        String newUser = this.userService.update(oldUser, updatedUser);
        Assertions.assertEquals(updatedUser, newUser);
    }
}
