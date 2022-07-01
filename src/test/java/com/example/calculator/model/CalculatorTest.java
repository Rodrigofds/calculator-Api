package com.example.calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator;
    Double numA;
    Double numB;

    @BeforeEach
    void setup(){
        calculator = new Calculator();
        numA = 5.0;
        numB = 2.0;
    }

    @Test
    void sumTest() {
        assertEquals(7.0, calculator.sum(numA, numB));
        assertNotEquals(1.0, calculator.sum(numA, numB));
    }

    @Test
    public void numbersNullSumTest() {
        numA = null; numB = null;
        Calculator calculadora = new Calculator();
        String msg = "Número 1 e número 2 são obrigatórios.";

        String mensagem = assertThrows(NullPointerException.class, () -> {
            calculadora.sum(numA,numB);
        }
        ).getMessage();
        assertEquals(msg, mensagem);
    }

    @Test
    void subTest() {
        assertEquals(3.0, calculator.sub(numA, numB));
        assertNotEquals(1.0, calculator.sub(numA, numB));
    }

    @Test
    void divideTest() {
        assertEquals(2.5, calculator.divide(numA, numB));
        assertNotEquals(1.0, calculator.divide(numA, numB));
    }

    @Test
    public void divisionByZeroTest() {
        numB = 0.0;
        assertNotEquals(7.0, calculator.divide(numA, numB));
    }

    @Test
    void factorialTest() {
        Integer num = 7;
        assertEquals(5040, calculator.factorial(num));
        assertNotEquals(720, calculator.factorial(num));
    }

    @Test
    void integerToBinaryTest() {
        Integer num = 20;
        Integer atual = calculator.integerToBinary(num);
        assertEquals(10100, atual);
        assertNotEquals(01010, atual);
    }

    @Test
    void integerToHexadecimalTest() {
        Integer num = 170;
        assertEquals("AA", calculator.integerToHexadecimal(num));
        assertNotEquals("AB", calculator.integerToHexadecimal(num));
    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate date1 = LocalDate.of(2020, 3, 15);
        LocalDate date2 = LocalDate.of(2020, 3, 29);
        assertEquals(14 , calculator.calculeDayBetweenDate(date1, date2));
        assertNotEquals(17 , calculator.calculeDayBetweenDate(date1, date2));
    }
}
