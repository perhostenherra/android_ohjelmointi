package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

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
    Animation animation;




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

        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roundanimation);
        ImageView image = (ImageView) findViewById(R.id.imageButton1);
    }

    public void handleClickEvents(View view) {
        switch (view.getId()) {
            case R.id.imageButton1:
                if (randomNr == 1) {
                    gameBtn1.startAnimation(animation);
                    gameBtn1.setImageResource(R.mipmap.ic_launcher_demoni);
                    gameBtn1.setBackgroundColor(Color.WHITE);
                    System.out.println("Voitit pelin");


                } else gameBtn1.setVisibility(View.INVISIBLE);



                    break;

            case R.id.imageButton2:
                if (randomNr == 2) {
                    gameBtn2.startAnimation(animation);
                    gameBtn2.setImageResource(R.mipmap.ic_launcher_demoni);
                    gameBtn2.setBackgroundColor(Color.WHITE);


                } else gameBtn2.setVisibility(View.INVISIBLE);

                    break;

            case R.id.imageButton3:
                if (randomNr == 3) {
                    gameBtn3.startAnimation(animation);
                    gameBtn3.setImageResource(R.mipmap.ic_launcher_demoni);
                    gameBtn3.setBackgroundColor(Color.WHITE);


                } else gameBtn3.setVisibility(View.INVISIBLE);
                    break;

            case R.id.imageButton4:
                gameBtn4.setVisibility(View.INVISIBLE);
                if (randomNr == 4) {
                    gameBtn4.startAnimation(animation);
                    gameBtn4.setImageResource(R.mipmap.ic_launcher_demoni);
                    gameBtn4.setBackgroundColor(Color.WHITE);


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



