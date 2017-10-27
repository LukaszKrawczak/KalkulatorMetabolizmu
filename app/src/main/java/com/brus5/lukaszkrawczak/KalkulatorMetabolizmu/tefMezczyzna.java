package com.brus5.lukaszkrawczak.KalkulatorMetabolizmu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class tefMezczyzna extends AppCompatActivity {

    int visible;
    double Stala1 = 0.1;
    double wyniktefbmrMezczyzna;
    double resultTef;
    double resultBMRteaTEF;
    double resultTea;
    double highIntensity = 0.5;
    double midIntensity = 0.3;
    String hehe = "Twój TEF to: ";
    String wynikBMR = "Twój BMR to: ";


    @BindView(R.id.bmrTextView)
    TextView bmrTextView;
    @BindView(R.id.tefTextView)
    TextView tefTextView;
    @BindView(R.id.midRadioButton)
    RadioButton midRadioButton;
    @BindView(R.id.highRadioButton)
    RadioButton highRadioButton;
    @BindView(R.id.loadTeaTextView)
    TextView loadTeaTextView;
    @BindView(R.id.neatButton)
    Button neatButton;
    @BindView(R.id.nextPageButton)
    Button nextPageButton;
    @BindView(R.id.BMRTEATEFTextView)
    TextView BMRTEATEFTextView;
    @BindView(R.id.loadTefTextView)
    TextView loadTefTextView;
    @BindView(R.id.tefInfoTextView)
    TextView tefInfoTextView;
    @BindView(R.id.imageViewInfo)
    ImageView imageViewInfo;
    @BindView(R.id.textView10)
    TextView TextView10;
    @BindView(R.id.textView8)
    TextView TextView8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tef_mezczyzna);
        ButterKnife.bind(this);

        bmrTextView.setText(getIntent().getStringExtra(""));

        String BMR = bmrTextView.getText().toString();

        resultTef = Stala1 * Double.valueOf(BMR);
        tefTextView.setText(String.valueOf(String.format("%.1f", resultTef) + " kCAL"));
        showResult();

        blinker();


    }
    private void blinker(){
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int timeToBlink = 1500;
                final Boolean isTrue = true;
                try{Thread.sleep(timeToBlink);}catch (Exception e){}
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        if (visible == 1){
                            imageViewInfo.animate().alpha(0.0f).setDuration(1000);

                            visible = 0;

                        } else if(visible == 0){

                            imageViewInfo.animate().alpha(1.0f).setDuration(1000);

                            visible = 1;
                        }
                        blinker();
                    }
                });
            }
        }).start();
    }

    public void showResult() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tefInfoTextView.setVisibility(View.VISIBLE);
                tefInfoTextView.startAnimation(AnimationUtils.loadAnimation(tefMezczyzna.this, android.R.anim.fade_in));
            }
        }, 1000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tefTextView.setVisibility(View.VISIBLE);
                tefTextView.startAnimation(AnimationUtils.loadAnimation(tefMezczyzna.this, android.R.anim.fade_in));
            }
        }, 1500);
    }


    @OnClick({R.id.neatButton, R.id.nextPageButton})
    public void onViewClicked(View view) {


        if (midRadioButton.isChecked()) {
            next();
        } else if (highRadioButton.isChecked()) {
            next();
        } else {
            Toast myToast = Toast.makeText(getApplicationContext(), "Proszę zaznaczyć jedną z opcji.", Toast.LENGTH_SHORT);
            myToast.show();
        }
    }

    public void next() {

        if (midRadioButton.isChecked()) {
            String BMR = bmrTextView.getText().toString();
            resultTea = midIntensity * Double.valueOf(BMR);
        }
        if (highRadioButton.isChecked()) {
            String BMR = bmrTextView.getText().toString();
            resultTea = highIntensity * Double.valueOf(BMR);
        }
        // String licz = wysilekTextView.getText().toString();
        loadTeaTextView.setText(String.valueOf(resultTea));
        loadTefTextView.setText(String.valueOf(resultTef));

        String BMR = bmrTextView.getText().toString();
        String TEA = loadTeaTextView.getText().toString();
        String TEF = loadTefTextView.getText().toString();

        resultBMRteaTEF = Double.valueOf(BMR) + Double.valueOf(TEA) + Double.valueOf(TEF);

        BMRTEATEFTextView.setText(String.valueOf(resultBMRteaTEF));

        String namevalue = BMRTEATEFTextView.getText().toString();
        Intent intent = new Intent(tefMezczyzna.this, neatMezczyzna.class);
        intent.putExtra("", namevalue);
        startActivity(intent);

        overridePendingTransition(R.animator.animation1, R.animator.animation2);

    }

    @OnClick(R.id.imageViewInfo)
    public void onViewClicked(){

        imageViewInfo.setVisibility(View.GONE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TextView10.setVisibility(View.VISIBLE);
                TextView10.startAnimation(AnimationUtils.loadAnimation(tefMezczyzna.this, android.R.anim.fade_in));
            }
        },1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TextView8.setVisibility(View.VISIBLE);
                TextView8.startAnimation(AnimationUtils.loadAnimation(tefMezczyzna.this, android.R.anim.fade_in));
            }
        },1500);
    }

}
