package com.example.simple_calculator;

import android.media.VolumeShaper;

public class MathSolver {

    private final StringBuilder currentInput = new StringBuilder();
    private double firstNumber = 0;
    private String pendingOperator = null;

    public String appendDigit(String digit){
        currentInput.append(digit);
        return currentInput.toString();
    }
}
