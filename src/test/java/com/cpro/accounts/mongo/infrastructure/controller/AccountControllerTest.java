package com.cpro.accounts.mongo.infrastructure.controller;

import com.cpro.accounts.mongo.constants.TestConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test de insercion
     * NOTA: DE MOMENTO NO UTILIZAR YA QUE NO SE UTILIZA BASE EN MEMORIA H2
     * Si AUN ASI SE DESEA UTILIZAR, CAMBIAR EL NAME, SUBIRLE UN NUMERO ejemplo unicoTest5
     * */
    /**
    @Test
    @DisplayName("Respuesta ok")
    void shouldResponseOK() throws Exception {
        mockMvc.perform(
                post("/account")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "name": "unicoTest4",
                                    "ownerIdentification": "1725552166",
                                    "maxValueTransfer": 1000.22,
                                    "value": 11.55
                                }
                                """)
        ).andExpect(status().isOk());
    }*/

    @Test
    @DisplayName("Traer todas las cuentas de un usuario")
    void shouldGetAllAccountsByOwner() throws Exception {

        mockMvc.perform(
                get("/account/%s".formatted(TestConstants.IDENTIFICATION_GET))
                        .content(MediaType.APPLICATION_JSON_VALUE)

        ).andExpect(status().isOk());
    }

}
