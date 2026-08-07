package com.vehiclecfg.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vehiclecfg.entities.Model;
import com.vehiclecfg.jwt.OAuth2LoginSuccessHandler;
import com.vehiclecfg.jwt.jwtFilter;
import com.vehiclecfg.jwt.jwtService;
import com.vehiclecfg.services.ModelService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ModelController.class)
@AutoConfigureMockMvc(addFilters = false)
class ModelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @MockitoBean
    private ModelService modelService;

    // ===== Mock Security Beans =====

    @MockitoBean
    private jwtFilter jwtFilter;

    @MockitoBean
    private jwtService jwtService;

    @MockitoBean
    private UserDetailsService userDetailsService;

    @MockitoBean
    private OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;

    // ===============================

    @Test
    void shouldAddModelSuccessfully() throws Exception {

        Model model = new Model();
        model.setModelId(1);
        model.setModelName("Creta");

        when(modelService.addModel(any(Model.class)))
                .thenReturn(model);

        mockMvc.perform(post("/models")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(model)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.modelId").value(1))
                .andExpect(jsonPath("$.modelName").value("Creta"));
    }

    @Test
    void shouldGetAllModels() throws Exception {

        Model model = new Model();
        model.setModelId(1);
        model.setModelName("Creta");

        when(modelService.getAllModels())
                .thenReturn(List.of(model));

        mockMvc.perform(get("/models"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].modelId").value(1))
                .andExpect(jsonPath("$[0].modelName").value("Creta"));
    }

    @Test
    void shouldGetModelById() throws Exception {

        Model model = new Model();
        model.setModelId(1);
        model.setModelName("Creta");

        when(modelService.getModelById(1))
                .thenReturn(model);

        mockMvc.perform(get("/models/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.modelId").value(1))
                .andExpect(jsonPath("$.modelName").value("Creta"));
    }

    @Test
    void shouldUpdateImage() throws Exception {

        Model model = new Model();
        model.setModelId(1);
        model.setImagePath("car.png");

        when(modelService.updateImage(1, "car.png"))
                .thenReturn(model);

        mockMvc.perform(patch("/models/1/image")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                Map.of("imagePath", "car.png"))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.imagePath").value("car.png"));
    }

}