package com.discretesurvivors.physicscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    /* List of formulas
    velocity = vx0 + axt
    distance = distance0 + vx0t + 1/2axt^2
    vx^2 = vx^20 + 2ax(x-x0)
    w = w0 + at
    k = 1/2 Iw^2

     */

    ArrayList<String> formulas = new ArrayList<String>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        formulas.add("velocity");
        formulas.add("distance");
        formulas.add("vx^2");
        formulas.add("w");
        formulas.add("k");

        LinearLayout LinearLayoutView = new LinearLayout(this);
        TextView tv = (TextView) findViewById(R.id.textView_main);

        StringBuilder formulasBuilder = new StringBuilder();

        for(int i =0; i < formulas.size(); i++) {
            formulasBuilder.append(formulas.get(i) + "\n");
        }
        tv.setText(formulasBuilder.toString());

    }
}