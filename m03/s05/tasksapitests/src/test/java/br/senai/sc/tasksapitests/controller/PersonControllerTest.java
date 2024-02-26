package br.senai.sc.tasksapitests.controller;

import br.senai.sc.tasksapitests.model.transport.PersonDTO;
import br.senai.sc.tasksapitests.model.transport.operations.create.CreatePersonForm;
import br.senai.sc.tasksapitests.service.PersonService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    private Gson gson;

    @BeforeEach
    void setup() {
        this.gson = new Gson();
    }

    @Test
    @WithMockUser(username = "teste", password = "teste")
    @DisplayName("Busca por usuário devidamente autenticado, deve retornar OK")
    void getUserWithAuthenticationReturnsOk() throws Exception {
        /* Arrange */
        String id = UUID.randomUUID().toString();
        PersonDTO personDTO =
                new PersonDTO(id, "Usuário teste", "teste@example.com");

        BDDMockito.given(this.personService.getByGuid(id)).willReturn(personDTO);

        /* Act / Assert */
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/person/" + id))
                .andExpect(status().isOk());
    }

    @Test
    void getUserWithoutAuthenticationReturnsUnauthorized() throws Exception {
        /* Arrange */
        String id = UUID.randomUUID().toString();
        PersonDTO personDTO =
                new PersonDTO(id, "Usuário teste", "teste@example.com");

        BDDMockito.given(this.personService.getByGuid(id)).willReturn(personDTO);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/person/" + id))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "teste", password = "teste")
    void sendRequestForUrlReturnsMethodNotAllowed() throws Exception {
        /* Arrange */
        String id = UUID.randomUUID().toString();
        PersonDTO personDTO =
                new PersonDTO(id, "Usuário teste", "teste@example.com");

        BDDMockito.given(this.personService.getByGuid(id)).willReturn(personDTO);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/person"))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    void createUserWithEmptyBodyExpectsBadRequest() throws Exception {
        CreatePersonForm form = new CreatePersonForm("", null, null, null);
        String formAsJson = this.gson.toJson(form);

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders
                        .post("/person")
                        .content(formAsJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        Assertions.assertEquals(400, response.getStatus());
    }

    @Test
    void createUserExpects201() throws Exception {
        CreatePersonForm form =
                new CreatePersonForm("Usuário teste", "test@example.com", "UmaSenhaForte", null);
        String formAsJson = this.gson.toJson(form);

        BDDMockito.given(this.personService.create(form))
                .willReturn(new PersonDTO(UUID.randomUUID().toString(),
                        form.name(),
                        form.email()));

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/person")
                        .content(formAsJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.header().exists("Location"));
    }
}
