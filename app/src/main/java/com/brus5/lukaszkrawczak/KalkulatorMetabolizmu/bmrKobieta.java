package com.brus5.lukaszkrawczak.KalkulatorMetabolizmu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class bmrKobieta extends AppCompatActivity {



    @BindView(R.id.weightEditText)
    EditText weightEditText;
    @BindView(R.id.heightEditText)
    EditText heightEditText;
    @BindView(R.id.ageEditText)
    EditText ageEditText;
    @BindView(R.id.bmrButton)
    Button bmrButton;
    @BindView(R.id.bmrTextView)
    TextView bmrTextView;
    @BindView(R.id.nextPageButton)
    Button nextButton;
    @BindView(R.id.bodyFatTextView)
    TextView bodyFatTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr_kobieta);
        ButterKnife.bind(this);

        // overridePendingTransition(R.animator.animation2, R.animator.animation1);

    }


    @OnClick({R.id.bmrButton, R.id.nextPageButton})
    public void onViewClicked(View view) {

        String WEIGHT = weightEditText.getText().toString();
        String HEIGHT = heightEditText.getText().toString();
        String AGE = ageEditText.getText().toString();

        switch (view.getId()) {

            case R.id.nextPageButton:

                boolean isError = false;

                if (WEIGHT.isEmpty()){
                    weightEditText.setError("Proszę podać wagę w kilogramach.");
                    return;
                }
                if (WEIGHT.startsWith("0")){
                    weightEditText.setError("Proszę podać prawidłową wagę.");
                    return;
                }

                Integer WEIGHT2 = Integer.valueOf(WEIGHT);

                if (WEIGHT2 < 20 || WEIGHT2 > 140){
                    weightEditText.setError("Proszę podać prawidłową wagę");
                    isError = true;
                }
                if (HEIGHT.isEmpty()){
                    heightEditText.setError("Proszę podać wzrost w centymetrach.");
                    return;
                }
                if (HEIGHT.startsWith("0")){
                    heightEditText.setError("Proszę podać prawidłowy wzrost.");
                    return;
                }

                Integer HEIGHT2 = Integer.valueOf(HEIGHT);

                if (HEIGHT2 < 40 || HEIGHT2 > 240){
                    heightEditText.setError("Proszę podać prawidłowy wzrost.");
                    isError = true;
                }
                if (AGE.isEmpty()){
                    ageEditText.setError("Proszę podać wiek.");
                    return;
                }
                if (AGE.startsWith("0")){
                    ageEditText.setError("Proszę podać prawidowy wiek.");
                    return;
                }

                Integer AGE2 = Integer.valueOf(ageEditText.getText().toString());

                if (AGE2 == 0){
                    ageEditText.setError("Musisz uzupełnić pole.");
                    isError = true;
                }
                if (AGE2 <= 5 || AGE2 > 140){
                    ageEditText.setError("Proszę podać prawidłowy wiek.");
                    isError = true;
                }
                if (!isError){
                    next();
                }
        }
    }




    private void next() {

        double Stala1 = 665.09;
        double Stala2 = 9.56;
        double Stala3 = 1.85;
        double Stala4 = 4.67;
        double bodyfat = 0.83;      // Static variable whitch is part of this object. This variable means, that woman has 17% of bodyfat.
        double BMRRESULT;

        String WEIGHT = weightEditText.getText().toString();
        String HEIGHT = heightEditText.getText().toString();
        String AGE = ageEditText.getText().toString();


        double bodyFatTextView = Integer.parseInt(WEIGHT) * bodyfat;



        BMRRESULT = Stala1 + (Stala2  * bodyFatTextView) + (Stala3 * Integer.parseInt(HEIGHT)) - (Stala4 * Integer.parseInt(AGE));
        bmrTextView.setText(Double.toString(BMRRESULT));

        String namevalue = bmrTextView.getText().toString();
        Intent intent = new Intent(bmrKobieta.this, tefKobieta.class);
        intent.putExtra("", namevalue);
        startActivity(intent);

        overridePendingTransition(R.animator.animation1, R.animator.animation2);
    }




}
