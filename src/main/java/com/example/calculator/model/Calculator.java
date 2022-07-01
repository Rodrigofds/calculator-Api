package com.example.calculator.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Component
public class Calculator {

    public Calculator() {
    }

    public Double sum(Double number1, Double number2) {
        // validação -> throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        if(number1 == null || number2 == null)
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");

        return number1+number2;
    }

    public Double sub(Double number1, Double number2) {
        // validação -> throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        if(number1 == null || number2 == null)
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");

        return number1-number2;
    }

    public Double divide (Double number1, Double number2)  {
        // validação -> throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        // validação -> throw new ArithmeticException("Divisão por zero não é permitido.");
        if(number1 == null || number2 == null){
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }else if(number2 == 0){
            throw new ArithmeticException("Divisão por zero não é permitido.");
        }

        return number1/number2;
    }

    public Integer factorial(Integer factorial) {
        // validação -> throw new NullPointerException("Número é obrigatório.");
        if(factorial == null || factorial < 0)
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");

        int resultado = 1;
        for(int i = 1; i <= factorial; i++){
            resultado *= i;
        }

        return resultado;
    }

    // Exemplos:
    // Integer = 1 -> Binary = 1
    // Integer = 5 -> Binary = 101
    // Integer = 20 -> Binary = 10100
    public Integer integerToBinary(Integer integer) {
        return Integer.valueOf(Integer.toBinaryString(integer));
    }

    public String integerToHexadecimal(Integer integer) {
        return Integer.toHexString(integer).toUpperCase();
    }

    // Exemplos
    // Date 1 = LocalDate.of(2020, 3, 15);
    // Date 2 = LocalDate.of(2020, 3, 29)
    // Total de dias = 14
    public int calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
        Long dias = DAYS.between(date1, date2);

        return dias.intValue();
    }

}
