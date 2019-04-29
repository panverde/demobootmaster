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


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SubjectControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void createSubject() throws Exception{
        this.mvc.perform(post("/subject/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("    {\n" +
                        "        \"subjectName\": \"H2DATABASE\"\n" +
                        "    }")).andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void createSubjectEmpty() throws Exception{
        this.mvc.perform(post("/subject/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("    {\n" +
                        "        \"subjectName\": \"\"\n" +
                        "    }")).andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void updateExistSubject() throws Exception {

        this.mvc.perform(put("/subject/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("    {\n" +
                        "        \"subjectName\": \"H2DATABASECORSE\"\n" +
                        "    }")).andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void listAllSubject() throws Exception {

        this.mvc.perform(get("/subject/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json; charset=utf-8"));
    }

    @Test
    public void deleteSubject() throws Exception{
        this.mvc.perform(MockMvcRequestBuilders.delete("/subject/2"))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteSubjectNoExist() throws Exception{
        this.mvc.perform(MockMvcRequestBuilders.delete("/subject/888"))
                .andExpect(status().isOk());
    }

    @Test
    public void updateNoExistSubject() throws Exception {

        this.mvc.perform(put("/subject/999")
                .contentType(MediaType.APPLICATION_JSON)
                .content("    {\n" +
                        "        \"subjectName\": \"H2DATABASECORSE\"\n" +
                        "    }")).andExpect(status().isOk())
                .andReturn();
    }

}