package com.example.lcbeerservice.web.controller;

import com.example.lcbeerservice.bootstrap.BeerLoader;
import com.example.lcbeerservice.web.model.BeerDto;
import com.example.lcbeerservice.web.model.BeerStyleEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class BeerControllerTest {

    @Autowired
    MockMvc mvcMock;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        mvcMock.perform(
                get("/api/v1/beer/"+ UUID.randomUUID().toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveBeer() throws Exception {
    BeerDto reqObj = getValidBeerDto();
    String reqBody = objectMapper.writeValueAsString(reqObj);

    mvcMock.perform(post("/api/v1/beer")
            .contentType(MediaType.APPLICATION_JSON)
            .content(reqBody))
            .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        BeerDto reqObj = getValidBeerDto();
        String reqBody = objectMapper.writeValueAsString(reqObj);

        mvcMock.perform(put("/api/v1/beer/"+UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(reqBody))
                .andExpect(status().isNoContent());

    }

    BeerDto getValidBeerDto(){
        return BeerDto.builder()
                .beerName("My Beer")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal("2.99"))
                .upc(BeerLoader.BEER_1_UPC)
                .build();
    }
}