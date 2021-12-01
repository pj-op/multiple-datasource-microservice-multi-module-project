package org.ac.controller;


import org.ac.entities.Actor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ActorControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Before
    public void init() {
        System.out.println("ActorControllerTest.init");
    }

    @Test
    public void allActorList_test() throws Exception {

        List<Actor> myList = Arrays.asList(new Actor(1, "PJ", "OP", Date.valueOf(LocalDate.now())),
                new Actor(2, "PJ2", "OPQR", Date.valueOf(LocalDate.now())));

        mockMvc.perform(get("/api/actors"))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    myList.stream().collect(Collectors.toList());
                });
    }

    @Test
    public void greetPerson_test() throws Exception {

        String pathParam = "pranjal";
        String expectedResult = "hello and hi there!!!... ".concat(pathParam);

        mockMvc.perform(get("/api/hi/".concat(pathParam)))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResult));
    }

    @After
    public void cleanUp() {
        System.out.println("ActorControllerTest.cleanUp");
    }

}
