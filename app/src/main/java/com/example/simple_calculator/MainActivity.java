package com.example.simple_calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private MathSolver mathSolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        mathSolver = new MathSolver();

        setupButtons();
    }

    private void setupButtons(){
        int[] digitIds = {
                R.id.buttonZero, R.id.buttonOne, R.id.buttonTwo,
                R.id.buttonThree, R.id.buttonFour, R.id.buttonFive,
                R.id.buttonSix, R.id.buttonSeven, R.id.buttonEight, R.id.buttonNine
        };

        for (int id : digitIds){
            Button btn = findViewById(id);
            if (btn != null){
                btn.setOnClickListener(v -> {
                    String text = mathSolver.appendDigit(btn.getText().toString());
                    textView.setText(text);
                });
            }
        }
    }
}