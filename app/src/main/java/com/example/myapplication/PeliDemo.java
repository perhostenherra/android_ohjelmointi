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

    public class generateRandom {
        public void main(String args[]) {
            Random rand = new Random();
            int rand_int1 = rand.nextInt(5);
            System.out.println("Random Integers" + rand_int1);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peli_demo);

        gameBtn1 = findViewById(R.id.imageButton1);
        gameBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { handleClickEvents(view);}
        });
        gameBtn2 = findViewById(R.id.imageButton2);
        gameBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { handleClickEvents(view);}
            });

        gameBtn3 = findViewById(R.id.imageButton3);
        gameBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { handleClickEvents(view);}
        });

        gameBtn4 = findViewById(R.id.imageButton4);
        gameBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {handleClickEvents(view);}
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
            gameBtn1.setVisibility(View.INVISIBLE);

                break;

            case R.id.imageButton2:
                gameBtn2.setVisibility(View.INVISIBLE);
                break;

            case R.id.imageButton3:
                gameBtn3.setVisibility(View.INVISIBLE);
                break;

            case R.id.imageButton4:
                gameBtn4.setVisibility(View.INVISIBLE);
                break;

            case R.id.fab:
                finish();
                startActivity(getIntent());
                break;

            default:

        }


    }
    }



