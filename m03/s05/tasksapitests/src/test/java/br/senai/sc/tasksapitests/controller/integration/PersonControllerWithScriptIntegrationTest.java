package br.senai.sc.tasksapitests.controller.integration;

import br.senai.sc.tasksapitests.configuration.TestContainersDatabaseConfigurationWithScript;
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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class PersonControllerWithScriptIntegrationTest extends TestContainersDatabaseConfigurationWithScript {

    private static RequestSpecification specification;
    private static ObjectMapper objectMapper;

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
    }

    @Test
    void getUserByIntegrationTestShoulReturnSuccess() throws JsonProcessingException {
        String guid = "b80936a3-7363-4333-a180-2a7ef6933c61";
        String email = "user@example.com";
        String password = "UmaSenhaForte";

        String responseAsString = RestAssured.given()
                .spec(specification)
                .pathParam("id", guid)
                .auth().basic(email, password)
                .when().get("{id}").then().statusCode(200).extract().body().asString();

        PersonDTO personDTO = objectMapper.readValue(responseAsString, PersonDTO.class);

        Assertions.assertNotNull(personDTO);
        Assertions.assertNotNull(personDTO.guid());
        Assertions.assertNotNull(personDTO.name());
        Assertions.assertNotNull(personDTO.email());

        Assertions.assertEquals("Usuário Teste", personDTO.name());
        Assertions.assertEquals(email, personDTO.email());
    }
}
