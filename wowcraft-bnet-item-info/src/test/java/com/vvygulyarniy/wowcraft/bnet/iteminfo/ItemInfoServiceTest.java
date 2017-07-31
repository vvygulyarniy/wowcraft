package com.vvygulyarniy.wowcraft.bnet.iteminfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ItemInfoServiceTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void name() throws Exception {

        mvc.perform(get("/items/18803").accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(content().string("{\"id\":18803,\"name\":\"Лавовый отвал Вентурона\"}"));
    }
}