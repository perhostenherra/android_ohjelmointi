package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button peliDemoButton;
    private Button welcomeButton;
    private View welcomeTextView;
    public static final String TAG ="MyAppMessage";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcomeButton = findViewById(R.id.hello_button);
        welcomeTextView = findViewById(R.id.textView);
        peliDemoButton = findViewById(R.id.peliDemoButton);
        Log.e(TAG, "activating play view");

        peliDemoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickEvents(view);
            }
        });
        welcomeButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                handleClickEvents(v);
            }

        });

    }

    public void handleClickEvents (View v)
    {
        switch(v.getId()) {
            case R.id.peliDemoButton:
                Intent i = new Intent(this,PeliDemo.class);
                startActivity(i);

                break;

            case R.id.hello_button:
                if (welcomeTextView.getVisibility() == View.VISIBLE)
                    welcomeTextView.setVisibility(View.INVISIBLE);

                else if (welcomeTextView.getVisibility() == View.INVISIBLE)
                    welcomeTextView.setVisibility(View.VISIBLE);

                break;

            default:
        }
    }
}




