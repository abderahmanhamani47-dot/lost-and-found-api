package com.polytech.lostandfound.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.polytech.lostandfound.dto.ItemRequest;
import com.polytech.lostandfound.model.ItemStatus;
import com.polytech.lostandfound.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerTest {

    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper objectMapper;
    @Autowired ItemRepository repository;

    @BeforeEach
    void cleanDatabase() {
        repository.deleteAll();
    }

    private ItemRequest validRequest() {
        return new ItemRequest(
                "Black backpack",
                "Black backpack found near the library.",
                "Bag",
                "Nancy library",
                LocalDate.now(),
                ItemStatus.FOUND
        );
    }

    @Test
    void shouldCreateAndGetItem() throws Exception {
        mockMvc.perform(post("/api/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(validRequest())))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Black backpack"));

        mockMvc.perform(get("/api/items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void shouldReturnNotFoundForUnknownItem() throws Exception {
        mockMvc.perform(get("/api/items/999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404));
    }

    @Test
    void shouldRejectInvalidItem() throws Exception {
        ItemRequest invalid = new ItemRequest("", "", "", "", null, null);

        mockMvc.perform(post("/api/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalid)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Validation failed"));
    }

    @Test
    void shouldExposeProjectDocumentation() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Lost & Found API"))
                .andExpect(jsonPath("$.swagger").value("/swagger-ui.html"));
    }
}
