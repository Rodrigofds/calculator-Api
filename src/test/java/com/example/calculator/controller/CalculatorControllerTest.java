package com.example.calculator.controller;

import com.example.calculator.model.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    Calculator calculator;

    @Test
    void messageWelcome() throws Exception {
        RequestBuilder request = get("/calculator/welcome");
        MvcResult result = mvc
                .perform(request)
                .andReturn();
        assertEquals("Bem vindo à CALCULATOR API REST.", result
                .getResponse()
                .getContentAsString());
    }

    @Test
    void addNumbers() throws Exception {
        RequestBuilder request = get("/calculator/addNumbers")
                .param("n1", "5.0")
                .param("n2", "2.0");
        MvcResult result = mvc
                .perform(request)
                .andReturn();
        assertEquals("7.0", result.getResponse().getContentAsString());
    }

    @Test
    void subNumbers() throws Exception {
        RequestBuilder request = get("/calculator/subNumbers")
                .param("number1", "5.0")
                .param("number2", "2.0");
        MvcResult result = mvc
                .perform(request)
                .andReturn();
        assertEquals("3.0", result
                .getResponse()
                .getContentAsString());
    }

    @Test
    void divideNumbers() throws Exception {
        RequestBuilder request = get("/calculator/divideNumbers")
                .param("number1", "5.0")
                .param("number2", "2.0");
        MvcResult result = mvc
                .perform(request)
                .andReturn();
        assertEquals("2.5", result
                .getResponse()
                .getContentAsString());
    }

    @Test
    void factorial() throws Exception {
        RequestBuilder request = get("/calculator/factorial")
                .param("factorial", "7");
        MvcResult result = mvc
                .perform(request)
                .andReturn();
        assertEquals("5040", result
                .getResponse()
                .getContentAsString());
    }

    @Test
    void calculeDayBetweenDate() throws Exception {
        RequestBuilder request = get("/calculator/calculeDayBetweenDate")
                .param("localDate1", "2020-03-15")
                .param("localDate2", "2020-03-29");
        MvcResult result = mvc
                .perform(request)
                .andReturn();
        assertEquals("14", result
                .getResponse()
                .getContentAsString());
    }

    @Test
    void integerToBinary() throws Exception {
        RequestBuilder request = get("/calculator/integerToBinary")
                .param("number1", "20");
        MvcResult result = mvc
                .perform(request)
                .andReturn();
        assertEquals("10100", result
                .getResponse()
                .getContentAsString());
    }

    @Test
    void integerToHexadecimal() throws Exception {
        RequestBuilder request = get("/calculator/integerToHexadecimal")
                .param("number1", "170");
        MvcResult result = mvc
                .perform(request)
                .andReturn();
        assertEquals("AA", result
                .getResponse()
                .getContentAsString());
    }
}
