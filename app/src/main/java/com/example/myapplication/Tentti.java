package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Tentti extends AppCompatActivity {

    TextInputEditText textAmount;
    private TextView valueText;
    int amount;
    private Button sekButton;
    private Button nokButton;
    private Button dkkButton;
    String inTotal;
    double total;
    public static final String TAG = "My TAG";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentti);
        sekButton = findViewById(R.id.buttonSek);
        nokButton = findViewById(R.id.buttonNok);
        dkkButton = findViewById(R.id.buttonDkk);
        valueText = findViewById(R.id.textValue);
        textAmount = findViewById(R.id.amount);


        sekButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //amount = Integer.parseInt(String.valueOf(textAmount));
                    amount = Integer.parseInt(textAmount.getText().toString());
                    //amount = 15;
                    total = amount * 0.09968;
                    inTotal = String.valueOf(total);
                    valueText.setText(inTotal + " €");
                }
                catch(Exception e) {
                    valueText.setText("Valitse valuutan määrä");
                    Log.e(TAG,"Valitse valuutan määrä");
                }


            }
        });

        nokButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //amount = Integer.parseInt(String.valueOf(textAmount));
                    amount = Integer.parseInt(textAmount.getText().toString());
                    total = amount * 0.10288;
                    inTotal = String.valueOf(total);
                    valueText.setText(inTotal+" €");
                }
                catch(Exception e) {
                    valueText.setText("Valitse valuutan määrä");
                    Log.e(TAG,"Valitse valuutan määrä");
                }


            }
        });

        dkkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //amount = Integer.parseInt(String.valueOf(textAmount));
                    amount = Integer.parseInt(textAmount.getText().toString());
                    total = amount * 0.13440;
                    inTotal = String.valueOf(total);
                    valueText.setText(inTotal+" €");
                }
                catch(Exception e) {
                    valueText.setText("Valitse valuutan määrä");
                    Log.e(TAG,"Valitse valuutan määrä");
                }

            }
        });

    }


}