package com.discretesurvivors.physicscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class formula2 extends AppCompatActivity {

    String finalAngularSpeed;
    String initialAngularSpeed;
    String time;
    String angularAcceleration;

    double calc;
    EditText tvFinalAngularSpeed;
    EditText tvInitialAngularSpeed;
    EditText tvTime;
    EditText tvAngularAcceleration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula1);

        Button btn1 = findViewById(R.id.button_1);
        Button btnr = findViewById(R.id.button_refresh);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(formula2.this, MainActivity.class));
            }
        });
        btnr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(formula2.this, formula2.class));
            }
        });
    }

    public boolean getNumbers() {
        tvTime = findViewById(R.id.editViewTime);
        tvInitialAngularSpeed = findViewById(R.id.editViewIAS);
        tvFinalAngularSpeed = findViewById(R.id.editViewFAS);
        tvAngularAcceleration = findViewById(R.id.editViewAA);

        initialAngularSpeed = tvInitialAngularSpeed.getText().toString();
        time = tvTime.getText().toString();
        finalAngularSpeed = tvFinalAngularSpeed.getText().toString();
        angularAcceleration = tvAngularAcceleration.getText().toString();


        return !initialAngularSpeed.isEmpty() && !time.isEmpty() && !finalAngularSpeed.isEmpty() ||
                !initialAngularSpeed.isEmpty() && !time.isEmpty() && !angularAcceleration.isEmpty() ||
                !initialAngularSpeed.isEmpty() && !finalAngularSpeed.isEmpty() && !angularAcceleration.isEmpty() ||
                !time.isEmpty() && !finalAngularSpeed.isEmpty() && !angularAcceleration.isEmpty();
    }

    public void doCalculations(View view) {
        if (getNumbers()) {
            if (time.isEmpty()) {
                calc = (Double.parseDouble(finalAngularSpeed) - Double.parseDouble(initialAngularSpeed)) / Double.parseDouble(angularAcceleration);
                tvTime.setText(Double.toString(calc));
            }
            if (initialAngularSpeed.isEmpty()) {
                calc = Double.parseDouble(finalAngularSpeed) - (Double.parseDouble(angularAcceleration) * Double.parseDouble(time));
                tvInitialAngularSpeed.setText(Double.toString(calc));
            }
            if (finalAngularSpeed.isEmpty()) {
                calc = Double.parseDouble(initialAngularSpeed) + (Double.parseDouble(angularAcceleration) * Double.parseDouble(time));
                tvFinalAngularSpeed.setText(Double.toString(calc));
            }
            if(angularAcceleration.isEmpty()) {
                calc = calc = (Double.parseDouble(finalAngularSpeed) - Double.parseDouble(initialAngularSpeed)) / Double.parseDouble(time);
            }
        }

    }
}
