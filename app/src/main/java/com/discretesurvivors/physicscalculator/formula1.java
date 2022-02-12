package com.discretesurvivors.physicscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class formula1 extends AppCompatActivity {

    boolean inputVelocity;
    boolean inputDistance;
    boolean inputTime;

    String vVelocity;
    String vDistance;
    String vTime;

    double iVelocity;
    double iDistance;
    double iTime;
    double calc;
    EditText tvVelocity;
    EditText tvDistance;
    EditText tvTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula1);

        Button btn1 = findViewById(R.id.button_1);
        Button btnr = findViewById(R.id.button_refresh);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(formula1.this, MainActivity.class));
            }
        });
        btnr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(formula1.this, formula1.class));
            }
        });
    }
    public boolean getNumbers() {
        tvVelocity = findViewById(R.id.editViewTime);
        tvDistance = findViewById(R.id.editViewDistance);
        tvTime = findViewById(R.id.editViewVelocity);
        tv
        vVelocity = tvVelocity.getText().toString();
        vTime = tvTime.getText().toString();
        vDistance = tvDistance.getText().toString();


         return !vVelocity.isEmpty() && !vTime.isEmpty() || !vVelocity.isEmpty() && !vDistance.isEmpty() || !vTime.isEmpty() && !vDistance.isEmpty();
    }

    public void doCalculations(View view) {
        if(getNumbers()) {
            if(vDistance.isEmpty()) {
                calc = Double.parseDouble(vVelocity) * Double.parseDouble(vTime);
                tvDistance.setText(Double.toString(calc));
            }
            if (vTime.isEmpty()) {
                calc = Double.parseDouble(vDistance) / Double.parseDouble(vVelocity);
                tvTime.setText(Double.toString(calc));
            }
            if(vVelocity.isEmpty()) {
                calc = Double.parseDouble(vDistance) / Double.parseDouble(vTime);
                tvVelocity.setText(Double.toString(calc));
            }
        }

    }
}