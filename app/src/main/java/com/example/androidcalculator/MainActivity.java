// MainActivity.java
package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText inputFirstNumber, inputSecondNumber;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFirstNumber = findViewById(R.id.inputFirstNumber);
        inputSecondNumber = findViewById(R.id.inputSecondNumber);
        textResult = findViewById(R.id.textResult);

        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonMinus = findViewById(R.id.buttonMinus);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);

        buttonPlus.setOnClickListener(view -> calculate('+'));
        buttonMinus.setOnClickListener(view -> calculate('-'));
        buttonMultiply.setOnClickListener(view -> calculate('*'));
        buttonDivide.setOnClickListener(view -> calculate('/'));
    }

    private void calculate(char operator) {
        String num1Str = inputFirstNumber.getText().toString();
        String num2Str = inputSecondNumber.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            textResult.setText("input two numbers");
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result;

        switch (operator) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/':
                if (num2 == 0) {
                    textResult.setText("divisor cannot be 0");
                    return;
                }
                result = num1 / num2;
                break;
            default: return;
        }

        textResult.setText("result: " + result);
    }
}
