package com.discretesurvivors.physicscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    /* List of formulas
    velocity = vx0 + axt
    distance = distance0 + vx0t + 1/2axt^2
    vx^2 = vx^20 + 2ax(x-x0)
    w = w0 + at
    k = 1/2 Iw^2

     */
    private ListView formulasDisplay;
    ArrayAdapter<String> formulasAdapter;
    EditText inputSearch;
    ArrayList<HashMap<String, String>> formulasList;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String formulas[] = {"velocity", "distance", "vx^2",
                "w", "k"};
        formulasDisplay = (ListView) findViewById(R.id.editlist_view);
        inputSearch = (EditText) findViewById(R.id.itemSearch);
        formulasAdapter = new ArrayAdapter<String>
                (this, R.layout.searchview, R.id.product_name, formulas);
        formulasDisplay.setAdapter(formulasAdapter);
        inputSearch.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                MainActivity.this.formulasAdapter.getFilter().filter(cs);
            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
            }

            public void afterTextChanged(Editable arg0) {

            }
        });

    }
}