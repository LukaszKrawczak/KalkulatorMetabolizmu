package com.brus5.lukaszkrawczak.KalkulatorMetabolizmu;

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

public class neatKobieta extends AppCompatActivity {

    double Stala = 300;
    double Stala1 = 400;
    double INTENSITY;
    int visible;

    @BindView(R.id.teaTextView)
    TextView teaTextView;
    @BindView(R.id.tteaTextView)
    TextView tteaTextView;
    @BindView(R.id.noTrainingRadioButton)
    RadioButton noTrainingRadioButton;
    @BindView(R.id.beginnerRadioButton)
    RadioButton beginnerRadioButton;
    @BindView(R.id.advencedRadioButton)
    RadioButton advencedRadioButton;
    @BindView(R.id.liczNeatButton)
    Button liczNeatButton;
    @BindView(R.id.cpmFinalTextView)
    TextView cpmFinalTextView;
    @BindView(R.id.cpmTextView)
    TextView cpmTextView;
    @BindView(R.id.infoTextView)
    TextView infoTextView;
    @BindView(R.id.neatinfoTextView)
    TextView neatinfoTextView;
    @BindView(R.id.neatinfo2TextView)
    TextView neatinfo2TextView;
    @BindView(R.id.neatinfo3TextView)
    TextView neatinfo3TextView;
    @BindView(R.id.neatinfo4TextView)
    TextView neatinfo4TextView;
    @BindView(R.id.neatinfo5TextView)
    TextView neatinfo5TextView;
    @BindView(R.id.imageViewInfo)
    ImageView imageViewInfo;
    @BindView(R.id.neatinfo1TextView)
    TextView neatinfo1TextView;
    @BindView(R.id.infoTextView1)
    TextView infoTextView1;
    @BindView(R.id.neatinfo6TextView)
    TextView neatinfo6TextView;
    @BindView(R.id.neatinfo7TextView)
    TextView neatinfo7TextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neat_kobieta);
        ButterKnife.bind(this);

        cpmTextView.setText(getIntent().getStringExtra(""));

        String NEAT = cpmTextView.getText().toString();

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

    @OnClick(R.id.liczNeatButton)
    public void onViewClicked(View view) {
        if (noTrainingRadioButton.isChecked()) {
            String NEAT = cpmTextView.getText().toString();
            INTENSITY = Double.valueOf(NEAT);
            showResult();
        } else if (beginnerRadioButton.isChecked()) {
            String NEAT = cpmTextView.getText().toString();
            INTENSITY = Double.valueOf(NEAT) + Stala;
            showResult();
        } else if (advencedRadioButton.isChecked()) {
            String NEAT = cpmTextView.getText().toString();
            INTENSITY = Double.valueOf(NEAT) + Stala1;
            showResult();
        } else {
            Toast myToast = Toast.makeText(getApplicationContext(), "Proszę zaznaczyć jedną z opcji.", Toast.LENGTH_SHORT);
            myToast.show();
        }
    }

    public void showResult() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                infoTextView.getText().toString();
                infoTextView.setVisibility(View.VISIBLE);
                infoTextView.startAnimation(AnimationUtils.loadAnimation(neatKobieta.this, android.R.anim.fade_in));
            }
        }, 1000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                cpmFinalTextView.setText(String.valueOf(String.format("%.0f", INTENSITY)) + " kCAL");

                cpmFinalTextView.startAnimation(AnimationUtils.loadAnimation(neatKobieta.this, android.R.anim.fade_in));
            }
        }, 2000);
    }

    @OnClick(R.id.imageViewInfo)
    public void onViewClicked() {


        imageViewInfo.setVisibility(View.GONE);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               // infoTextView1.animate().translationY(50);

                neatinfoTextView.setVisibility(View.VISIBLE);
                neatinfoTextView.startAnimation(AnimationUtils.loadAnimation(neatKobieta.this, android.R.anim.fade_in));
            }
        },500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                neatinfo1TextView.setVisibility(View.VISIBLE);
                neatinfo1TextView.startAnimation(AnimationUtils.loadAnimation(neatKobieta.this, android.R.anim.fade_in));
            }
        },1500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                neatinfo2TextView.setVisibility(View.VISIBLE);
                neatinfo2TextView.startAnimation(AnimationUtils.loadAnimation(neatKobieta.this, android.R.anim.fade_in));
            }
        },2000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                neatinfo3TextView.setVisibility(View.VISIBLE);
                neatinfo3TextView.startAnimation(AnimationUtils.loadAnimation(neatKobieta.this, android.R.anim.fade_in));
            }
        },2500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                neatinfo4TextView.setVisibility(View.VISIBLE);
                neatinfo4TextView.startAnimation(AnimationUtils.loadAnimation(neatKobieta.this, android.R.anim.fade_in));
            }
        },3000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                neatinfo5TextView.setVisibility(View.VISIBLE);
                neatinfo5TextView.startAnimation(AnimationUtils.loadAnimation(neatKobieta.this, android.R.anim.fade_in));
            }
        },3500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                neatinfo6TextView.setVisibility(View.VISIBLE);
                neatinfo6TextView.startAnimation(AnimationUtils.loadAnimation(neatKobieta.this, android.R.anim.fade_in));
            }
        }, 4000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                neatinfo7TextView.setVisibility(View.VISIBLE);
                neatinfo7TextView.startAnimation(AnimationUtils.loadAnimation(neatKobieta.this, android.R.anim.fade_in));
            }
        }, 4500);


    }

 /*   @OnClick(R.id.moreInfoButton)
    public void onViewClicked() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                neatinfoTextView.setVisibility(View.VISIBLE);
                neatinfoTextView.startAnimation(AnimationUtils.loadAnimation(neatKobieta.this, android.R.anim.fade_in));
            }
        }, 50);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                neatinfo2TextView.setVisibility(View.VISIBLE);
                neatinfo2TextView.startAnimation(AnimationUtils.loadAnimation(neatKobieta.this, android.R.anim.fade_in));
            }
        }, 100);

    }
*/

}
