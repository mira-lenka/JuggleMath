package com.mypibd.juggleMath.Controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest  // Loads the full application context
@AutoConfigureMockMvc
@ContextConfiguration(classes = CombinatoricsController.class)// Allows you to autowire MockMvc
class CombinatoricsControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    public void testCombination() throws Exception {
//
//        //String requestBody = "<n>5</n><k>3</k>";
//        String requestBody = "{ \"n\": 5, \"k\": 3 }";
//        mockMvc.perform(post("/api/combinatorics/combination")
//                .contentType(MediaType.APPLICATION_JSON).content(requestBody))
//                .andExpect(status().isOk())
//                .andExpect(content().string("10"));
//    }



}