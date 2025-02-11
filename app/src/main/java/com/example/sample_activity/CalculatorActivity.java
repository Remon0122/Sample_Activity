package com.example.sample_activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.Button_backSpace){
            removeLastDigit();
        }else {
            CLear();
        }
    }
    public void removeLastDigit(){
        String current = resultTv.getText().toString();
        if (current.isEmpty()){
            return;
        }
        resultTv.setText(current.substring(0,current.length()-1));
    }
    public void CLear(){
        resultTv.setText(null);
    }
    TextView resultTv;
    Button Button_Ac , Button_BackSpace;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        resultTv = findViewById(R.id.resultTv);
        Button_Ac = findViewById(R.id.Button_Ac);
        Button_BackSpace = findViewById(R.id.Button_backSpace);

    }
    public void onDigitCLick(View view){
        Button current = (Button) view;

        resultTv.append(current.getText().toString());

        Button_Ac.setOnClickListener(this);
        Button_BackSpace.setOnClickListener(this);
        Button_Ac.setOnClickListener(v -> CLear());
        Button_BackSpace.setOnClickListener(v -> removeLastDigit());
    }
    String savedNum = "";
    String savedOperator = "";
    public void onOperatorCLick(View view){
        Button clickedOperator = (Button) view;
        if (savedOperator.isEmpty()){
            savedNum = resultTv.getText().toString();
        } else {
            String newNumber = resultTv.getText().toString();
            savedNum = calculate(savedNum,savedOperator,newNumber);
        }
        savedOperator = clickedOperator.getText().toString();
        resultTv.setText("");
    }
    String calculate (String lhs, String Operator, String rhs){
        double h1 = Double.parseDouble(rhs);
        double h2 = Double.parseDouble(lhs);
        double result = 0;
        switch (Operator) {
            case "+":
                result = h1 + h2;
                break;
            case "-":
                result = h2 - h1;
                break;
            case "*":
                result = h1 * h2;
                break;
            case "/":
                result = h2 / h1;
                break;
        }
        return  result + "";
    }
    public void onEqualsClick(View view){
        String newNumber = resultTv.getText().toString();
        String result = calculate(savedNum, savedOperator,newNumber);
        resultTv.setText(result);
        savedOperator = "";
        savedNum = "";
    }
}