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
public class ClassControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void listAllClass() throws Exception{

        this.mvc.perform(get("/class/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json; charset=utf-8"));

    }

    @Test
    public void listClassStudent() throws Exception{

        this.mvc.perform(get("/class/list/7"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json; charset=utf-8"));

    }

    @Test
    public void createClass() throws Exception {
        this.mvc.perform(post("/class/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("    {\n" +
                        "        \"classCode\": \"CLASETEST\",\n" +
                        "        \"className\": \"CLASETEST\",\n" +
                        "        \"dateFrom\": \"2019-04-20\",\n" +
                        "        \"dateTo\": \"2019-05-20\",\n" +
                        "        \"subjectId\": {\n" +
                        "            \"id\": 8\n" +
                        "        },\n" +
                        "        \"teacherId\": {\n" +
                        "            \"id\": 8\n" +
                        "        }\n" +
                        "    }")).andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void createClassEmpty() throws Exception {
        this.mvc.perform(post("/class/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("    {\n" +
                        "        \"classCode\": \"\",\n" +
                        "        \"className\": \"CLASETEST\",\n" +
                        "        \"dateFrom\": \"2019-04-20\",\n" +
                        "        \"dateTo\": \"2019-05-20\",\n" +
                        "        \"subjectId\": {\n" +
                        "            \"id\": 8\n" +
                        "        },\n" +
                        "        \"teacherId\": {\n" +
                        "            \"id\": 8\n" +
                        "        }\n" +
                        "    }")).andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void updateExistClass() throws Exception {
        this.mvc.perform(put("/class/4")
                .contentType(MediaType.APPLICATION_JSON)
                .content("    {\n" +
                        "        \"classCode\": \"CLASEUPDATECOD\",\n" +
                        "        \"className\": \"CLASEUPDATENAME\",\n" +
                        "        \"dateFrom\": \"2019-04-21\",\n" +
                        "        \"dateTo\": \"2019-05-21\",\n" +
                        "        \"subjectId\": {\n" +
                        "            \"id\": 9\n" +
                        "        },\n" +
                        "        \"teacherId\": {\n" +
                        "            \"id\": 9\n" +
                        "        }\n" +
                        "    }")).andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void updateNoExistClass() throws Exception {
        this.mvc.perform(put("/class/100")
                .contentType(MediaType.APPLICATION_JSON)
                .content("    {\n" +
                        "        \"classCode\": \"CLASEUPDATECOD\",\n" +
                        "        \"className\": \"CLASEUPDATENAME\",\n" +
                        "        \"dateFrom\": \"2019-04-21\",\n" +
                        "        \"dateTo\": \"2019-05-21\",\n" +
                        "        \"subjectId\": {\n" +
                        "            \"id\": 9\n" +
                        "        },\n" +
                        "        \"teacherId\": {\n" +
                        "            \"id\": 9\n" +
                        "        }\n" +
                        "    }")).andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void deleteClass() throws Exception{
        this.mvc.perform(MockMvcRequestBuilders.delete("/class/5"))
                .andExpect(status().isOk());
    }
}