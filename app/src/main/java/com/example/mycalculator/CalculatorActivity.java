package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    Button plus, min, div, kali, adios;
    EditText num1, num2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.kalkulator);

        plus = findViewById(R.id.plus);
        min = findViewById(R.id.min);
        div = findViewById(R.id.div);
        kali = findViewById(R.id.kali);
        adios = findViewById(R.id.adios);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        result = findViewById(R.id.result);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num1.getText().toString().equals("")){
                    Toast.makeText(CalculatorActivity.this, "Input Angka Dibutuhkan", Toast.LENGTH_SHORT).show();
                }else if (num2.getText().toString().equals("")){
                    Toast.makeText(CalculatorActivity.this, "Input Angka Dibutuhkan", Toast.LENGTH_SHORT).show();
                }else{
                    Float a, b, c;
                    a = Float.parseFloat(num1.getText().toString());
                    b = Float.parseFloat(num2.getText().toString());
                    c = a + b;
                    result.setText("Result" + c);
                }
            }
        });

        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num1.getText().toString().equals("")){
                    Toast.makeText(CalculatorActivity.this, "Input Angka Dibutuhkan", Toast.LENGTH_SHORT).show();
                }else if (num2.getText().toString().equals("")){
                    Toast.makeText(CalculatorActivity.this, "Input Angka Dibutuhkan", Toast.LENGTH_SHORT).show();
                }else{
                    Float a, b, c;
                    a = Float.parseFloat(num1.getText().toString());
                    b = Float.parseFloat(num2.getText().toString());
                    c = a - b;
                    result.setText("Result" + c);
                }
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num1.getText().toString().equals("")){
                    Toast.makeText(CalculatorActivity.this, "Input Angka Dibutuhkan", Toast.LENGTH_SHORT).show();
                }else if (num2.getText().toString().equals("")){
                    Toast.makeText(CalculatorActivity.this, "Input Angka Dibutuhkan", Toast.LENGTH_SHORT).show();
                }else{
                    Float a, b, c;
                    a = Float.parseFloat(num1.getText().toString());
                    b = Float.parseFloat(num2.getText().toString());
                    c = a / b;
                    result.setText("Result" + c);
                }
            }
        });

        kali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num1.getText().toString().equals("")){
                    Toast.makeText(CalculatorActivity.this, "Input Angka Dibutuhkan", Toast.LENGTH_SHORT).show();
                }else if (num2.getText().toString().equals("")){
                    Toast.makeText(CalculatorActivity.this, "Input Angka Dibutuhkan", Toast.LENGTH_SHORT).show();
                }else{
                    Float a, b, c;
                    a = Float.parseFloat(num1.getText().toString());
                    b = Float.parseFloat(num2.getText().toString());
                    c = a * b;
                    result.setText("Result" + c);
                }
            }
        });

        adios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1.setText("");
                num2.setText("");
                result.setText("");
            }
        });

    }
}