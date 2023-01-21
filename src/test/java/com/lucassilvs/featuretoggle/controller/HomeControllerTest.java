package com.lucassilvs.featuretoggle.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ff4j.FF4j;
import org.ff4j.property.store.InMemoryPropertyStore;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(controllers = HomeController.class)
class HomeControllerTest {

    @MockBean
    private static FF4j ff4j;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void get() throws Exception {

        Mockito.when(ff4j.getPropertiesStore()).thenReturn(new InMemoryPropertyStore("Teste"));
        mockMvc.perform(MockMvcRequestBuilders
                        .request(HttpMethod.GET, "/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentType(MediaType.TEXT_HTML)
                );

    }
}