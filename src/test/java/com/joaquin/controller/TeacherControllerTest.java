package com.joaquin.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TeacherControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void createTeacher() throws Exception{

        this.mvc.perform(post("/teacher/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("    {\n" +
                        "        \"gender\": \"M\",\n" +
                        "        \"firstName\": \"PROFESOR01\",\n" +
                        "        \"middleName\": \"PROFESOR01\",\n" +
                        "        \"lastName\": \"PROFESOR01\",\n" +
                        "        \"otherTeacherDetails\": \"DETAILS01\"\n" +
                        "    }")).andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void createTeacherEmpty() throws Exception{

        this.mvc.perform(post("/teacher/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("    {\n" +
                        "        \"gender\": \"MMM\",\n" +
                        "        \"firstName\": \"PROFESOR01\",\n" +
                        "        \"middleName\": \"PROFESOR01\",\n" +
                        "        \"lastName\": \"PROFESOR01\",\n" +
                        "        \"otherTeacherDetails\": \"DETAILS01\"\n" +
                        "    }")).andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void updateExistTeacher() throws Exception {

        this.mvc.perform(put("/teacher/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("    {\n" +
                        "        \"gender\": \"M\",\n" +
                        "        \"firstName\": \"PROFESORJUNIT\",\n" +
                        "        \"middleName\": \"PROFESORJUNIT\",\n" +
                        "        \"lastName\": \"PROFESORJUNIT\",\n" +
                        "        \"otherTeacherDetails\": \"DETAILS JUNIT\"\n" +
                        "    }")).andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void listAllTeacher() throws Exception {

        this.mvc.perform(get("/teacher/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json; charset=utf-8"));

    }

    @Test
    public void deleteTeacher() throws Exception {

        this.mvc.perform(MockMvcRequestBuilders.delete("/teacher/2"))
          .andExpect(status().isOk());

    }
}