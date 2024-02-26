package br.senai.sc.tasksapitests.controller.integration;

import br.senai.sc.tasksapitests.configuration.TestContainersDatabaseConfigurationWithoutStaticClass;
import br.senai.sc.tasksapitests.model.transport.PersonDTO;
import br.senai.sc.tasksapitests.model.transport.operations.create.CreatePersonForm;
import br.senai.sc.tasksapitests.model.transport.operations.create.CreateResidenceAddressForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Não é uma prática recomendada criar testes que dependam um do outro.
 * Neste caso, criamos apenas para exemplificar como funcionaria.
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class PersonControllerIntegrationTest extends TestContainersDatabaseConfigurationWithoutStaticClass {

    private static RequestSpecification specification;
    private static ObjectMapper objectMapper;
    private static CreatePersonForm createPersonForm;
    private static PersonDTO personDTO;

    @BeforeAll
    static void setup() {
        objectMapper = new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        specification = new RequestSpecBuilder()
                .setBasePath("/person")
                .setPort(8888)
                .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
                .build();

        CreateResidenceAddressForm addressForm =
                new CreateResidenceAddressForm("Rua 01", "01", "Bairro 01", "Cidade 01", "Estado 01", "Brasil", null);

        createPersonForm =
                new CreatePersonForm("Usuário teste", "user@example.com", "UmaSenhaForte", addressForm);
    }

    @Test
    @Order(1)
    @DisplayName("Criar usuário com testes de integração deve retornar sucesso")
    void createUserWithIntegrationTestsShloudReturnSuccess() throws JsonProcessingException {
        String responseAsJson = RestAssured.given()
                .spec(specification)
                .contentType("application/json")
                .body(createPersonForm)
                .when().post().then().statusCode(201).extract().body().asString();

        personDTO = objectMapper.readValue(responseAsJson, PersonDTO.class);

        Assertions.assertNotNull(personDTO);
        Assertions.assertNotNull(personDTO.guid());
        Assertions.assertNotNull(personDTO.name());
        Assertions.assertNotNull(personDTO.email());

        Assertions.assertEquals(createPersonForm.name(), personDTO.name());
        Assertions.assertEquals(createPersonForm.email(), personDTO.email());
    }

    @Test
    @Order(2)
    @DisplayName("Buscar usuário por GUID retorna com sucesso")
    void getUserByIntegrationTestShouldReturnSuccess() throws JsonProcessingException {
        String responseAsJson = RestAssured.given()
                .spec(specification)
                .pathParam("id", personDTO.guid())
                .auth().basic(createPersonForm.email(), createPersonForm.password())
                .when().get("{id}").then().statusCode(200).extract().body().asString();

        PersonDTO personById = objectMapper.readValue(responseAsJson, PersonDTO.class);

        Assertions.assertNotNull(personById);
        Assertions.assertNotNull(personById.guid());
        Assertions.assertNotNull(personById.name());
        Assertions.assertNotNull(personById.email());

        Assertions.assertEquals(personDTO.name(), personById.name());
        Assertions.assertEquals(personDTO.email(), personById.email());
    }
}
