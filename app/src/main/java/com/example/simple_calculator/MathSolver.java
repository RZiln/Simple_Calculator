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

    public String clear(){
        currentInput.setLength(0);
        firstNumber = 0;
        pendingOperator = null;
        return "0";
    }

    public String clearEntry() {
        if (currentInput.length() > 0) {
            currentInput.deleteCharAt(currentInput.length() - 1);
        }

        return currentInput.length() == 0 ? "0" : currentInput.toString();
    }
    public double setOperator(String string){
        if (Objects.equals(string, "sqr")) {
            Double strToDobule = Double.parseDouble(string);
            return Math.sqrt(strToDobule);
        }
        return 0;
    }
}
