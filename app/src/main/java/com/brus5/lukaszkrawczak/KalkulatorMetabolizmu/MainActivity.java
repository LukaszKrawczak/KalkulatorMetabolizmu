package com.brus5.lukaszkrawczak.KalkulatorMetabolizmu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 4000;


    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.text1)
    TextView text1;
    @BindView(R.id.text2)
    TextView text2;
    @BindView(R.id.text3)
    TextView text3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, gender.class);
                startActivity(intent);
                overridePendingTransition(R.animator.animation1, R.animator.animation2);
                finish();
            }
        }, SPLASH_TIME_OUT);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setVisibility(View.VISIBLE);
                imageView.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_in_left));
            }
        }, 700);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                text1.setVisibility(View.VISIBLE);
                text1.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_in));
            }
        }, 1500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                text2.setVisibility(View.VISIBLE);
                text2.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_in));
            }
        }, 2500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                text3.setVisibility(View.VISIBLE);
                text3.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_in));
            }
        }, 3500);
    }
}
