package com.example.testtaskalfa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.testtaskalfa.controller.MainController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TestTaskAlfaApplicationTests {

    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private MainController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }



    @Test
    void getGif() throws Exception {
        this.mockMvc.perform(get("/gif/RUB")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getLatestExchangeRates() throws Exception {
        this.mockMvc.perform(get("/rates")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getCurrencies() throws Exception {
        this.mockMvc.perform(get("/currencies")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getYesterdayExchangeRates() throws Exception {
        this.mockMvc.perform(get("/yesterday")).andDo(print())
                .andExpect(status().isOk());
    }
}
