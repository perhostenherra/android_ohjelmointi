package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button welcomeButton;
    private View welcomeTextView;
    public static final String TAG ="MyAppMessage";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcomeButton = findViewById(R.id.hello_button);
        welcomeTextView = findViewById(R.id.textView);
        Log.e(TAG, "activating play view");
        welcomeButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (welcomeTextView.getVisibility() == View.VISIBLE)
                    welcomeTextView.setVisibility(View.INVISIBLE);

                else if (welcomeTextView.getVisibility() == View.INVISIBLE)
                    welcomeTextView.setVisibility(View.VISIBLE);
            }

        });
    }
}




