package com.joaquin.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class StudentClassControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void listAllStudentClass()throws Exception {
        this.mvc.perform(get("/studentclass/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json; charset=utf-8"));
    }

    @Test
    public void createStudentClass() throws Exception{
        this.mvc.perform(post("/studentclass/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("    {\n" +
                        "        \"primaryKey\": {\n" +
                        "            \"classId\": {\n" +
                        "                \"id\": 6\n" +
                        "                }\n" +
                        "            ,\n" +
                        "            \"student_id\": {\n" +
                        "                \"studentId\": 1\n" +
                        "            },\n" +
                        "            \"dateFrom\": \"2019-04-20T05:00:00.000+0000\"\n" +
                        "        },\n" +
                        "        \"dateTo\": \"2019-06-20T05:00:00.000+0000\"\n" +
                        "    }")).andExpect(status().isOk())
                .andReturn();
    }
}