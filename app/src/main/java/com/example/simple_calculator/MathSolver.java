package com.example.simple_calculator;

import java.util.Objects;

public class MathSolver {

    private final StringBuilder currentInput = new StringBuilder();
    private double firstNumber = 0;
    private String pendingOperator = null;

    public String appendDigit(String digit){
        currentInput.append(digit);
        return currentInput.toString();
    }

    public double setOperator(String string){
        if (Objects.equals(string, "sqr")) {
            Double strToDobule = Double.parseDouble(string);
            return Math.sqrt(strToDobule);
        }
        return 0;
    }
}
