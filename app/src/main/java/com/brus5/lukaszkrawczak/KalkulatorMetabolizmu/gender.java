

package com.brus5.lukaszkrawczak.KalkulatorMetabolizmu;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class gender extends AppCompatActivity {

    double bodyfatKobieta = 17;
    double bodyfatMezczyzna = 8;
    double BFKOBIETA;

    @BindView(R.id.kobietaRadioButton)
    RadioButton kobietaRadioButton;
    @BindView(R.id.mezczyznaRadioButton)
    RadioButton mezczyznaRadioButton;
    @BindView(R.id.bmrButton)
    Button bmrButton;
    @BindView(R.id.bodyfatkobietaTextView)
    TextView bodyfatkobietaTextView;
    @BindView(R.id.bodyfatmezczyznaTextView)
    TextView bodyfatmezczyznaTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        ButterKnife.bind(this);



    }




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick(R.id.bmrButton)
    public void onViewClicked() {

        if (kobietaRadioButton.isChecked()) {
            bodyfatkobietaTextView.setText(String.valueOf(bodyfatKobieta));
            Choosed_Woman();
        }
        else if (mezczyznaRadioButton.isChecked()) {
            bodyfatmezczyznaTextView.setText(String.valueOf(bodyfatMezczyzna));
            Choosed_Men();
        }
        else {
                Toast myToast = Toast.makeText(getApplicationContext(), "Proszę zaznaczyć jedną z opcji.", Toast.LENGTH_SHORT);
                myToast.show();
            }
    }

    private void Choosed_Woman() {
        String namevalue = bodyfatkobietaTextView.getText().toString();
        Intent intent = new Intent(gender.this, bmrKobieta.class);
        intent.putExtra("", namevalue);
        startActivity(intent);

        overridePendingTransition(R.animator.animation1, R.animator.animation2); // Animate the Activities

        // startActivity(new Intent(MainActivity.this, bmrKobieta.class));
    }

    private void Choosed_Men() {

        String namevalue = bodyfatmezczyznaTextView.getText().toString();
        Intent intent = new Intent(gender.this, bmrMezczyzna.class);
        intent.putExtra("", namevalue);
        startActivity(intent);

        overridePendingTransition(R.animator.animation1, R.animator.animation2); // Animate the Activities

        // startActivity(new Intent(MainActivity.this, bmrMezczyzna.class));
    }
}
