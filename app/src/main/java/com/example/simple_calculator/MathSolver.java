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
    public double setOperator(String operator){
        double number = getCurrentNumber();

        if (operator.equals("sqr")) {
            if (number > 0){
                currentInput.setLength(0);
                currentInput.append(formatResult(Math.sqrt(number)));

                return Math.sqrt(number);
            }
        }

        firstNumber = number;
        pendingOperator = operator;

        currentInput.setLength(0);

        return firstNumber;

    }


    public String calculate(){
        if (pendingOperator == null || currentInput.length() == 0){
            return currentInput.toString();
        }

        double secondNumber = getCurrentNumber();
        double result;

        switch (pendingOperator){
            case "+":
                result = firstNumber+secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber*secondNumber;
                break;
            case "/":
                if (secondNumber==0){
                    result = 0;
                }
                result = firstNumber/secondNumber;
                break;
            default:
                return  currentInput.toString();
        }

        currentInput.setLength(0);
        currentInput.append(formatResult(result));

        pendingOperator = null;
        firstNumber = 0;
        return currentInput.toString();
    }

    private double getCurrentNumber() {
        if (currentInput.length() == 0) {
            return 0;
        }

        return Double.parseDouble(currentInput.toString());
    }

    private String formatResult(double result) {
        if (result == (long) result) {
            return String.valueOf((long) result);
        }

        return String.valueOf(result);
    }
    public String getCurrentInput() {
        return currentInput.length() == 0 ? "0" : currentInput.toString();
    }

}
