package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;


public class PeliDemo extends AppCompatActivity {

    private ImageButton gameBtn1;
    private ImageButton gameBtn2;
    private ImageButton gameBtn3;
    private ImageButton gameBtn4;
    private FloatingActionButton fabBtn;
    private int randomNr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peli_demo);

        Random rand = new Random();
        randomNr = rand.nextInt(3)+1;
        ;
        gameBtn1 = findViewById(R.id.imageButton1);
        gameBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickEvents(view);
            }
        });
        gameBtn2 = findViewById(R.id.imageButton2);
        gameBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickEvents(view);
            }
        });

        gameBtn3 = findViewById(R.id.imageButton3);
        gameBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickEvents(view);
            }
        });

        gameBtn4 = findViewById(R.id.imageButton4);
        gameBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickEvents(view);
            }
        });

        fabBtn = findViewById(R.id.fab);
        fabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickEvents(view);
            }
        });


    }

    public void handleClickEvents(View view) {
        switch (view.getId()) {
            case R.id.imageButton1:
                if (randomNr == 1) {
                    gameBtn1.setImageResource(R.mipmap.ic_launcher_demoni);

                } else gameBtn1.setVisibility(View.INVISIBLE);


                    break;

            case R.id.imageButton2:
                if (randomNr == 2) {
                    gameBtn2.setImageResource(R.mipmap.ic_launcher_demoni);

                } else gameBtn2.setVisibility(View.INVISIBLE);

                    break;

            case R.id.imageButton3:
                if (randomNr == 3) {
                    gameBtn3.setImageResource(R.mipmap.ic_launcher_demoni);

                } else gameBtn3.setVisibility(View.INVISIBLE);
                    break;

            case R.id.imageButton4:
                gameBtn4.setVisibility(View.INVISIBLE);
                if (randomNr == 4) {
                    gameBtn4.setImageResource(R.mipmap.ic_launcher_demoni);

                } else gameBtn4.setVisibility(View.INVISIBLE);
                    break;

            case R.id.fab:
                finish();
                startActivity(getIntent());
                break;

            default:

        }


    }
}



