package com.example.massegraisseuse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     EditText taille;
     EditText poids;
     EditText age;
     RadioButton h;
     RadioButton f;
     TextView _lblResultat ;
     TextView _lblInterpretation ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        taille = findViewById(R.id.txtTaille);
        _lblResultat=findViewById(R.id.lblResulat);
        _lblInterpretation=findViewById(R.id.lblInterpretation);
        h=(RadioButton) findViewById(R.id.rdbHomme);
        f=(RadioButton) findViewById(R.id.rdbFemme);
        poids = findViewById(R.id.txtPoids);
        age = findViewById(R.id.txtAge);
        f = findViewById(R.id.rdbFemme);
        h = findViewById(R.id.rdbHomme);
        Button btnCalculIMG = findViewById(R.id.btnCalculIMG);
        btnCalculIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float t, p, imc;
                float img = 0;
                int a, s = 0;
                String i;
                t = Float.parseFloat(taille.getText().toString());
                p = Float.parseFloat(poids.getText().toString());
                a = Integer.parseInt(poids.getText().toString());
                imc = p / t * t;
                if (f.isChecked()) {
                    s = 0;
                }
                if (h.isChecked()) {
                    s = 1;
                }
                if (a >= 16) {
                    img = (float) (((1.20 * imc) + (0.23 * a)) - (10.8 * 1) - 5.4);
                } else {
                    img = (float) (((1.20 * imc) + (0.23 * a)) - (10.8 * 0) - 5.4);
                }
                _lblResultat.setText("votre IMG est " + img + "%");

                if (f.isChecked()) {
                    if (img < 25) {
                        _lblInterpretation.setText("trop maigre");
                    } else if (img >= 25 || img <= 30) {
                        _lblInterpretation.setText("pourcentage normal");
                    } else {
                        _lblInterpretation.setText("trop de graisse");
                    }
                } else {
                    if (img < 15) {
                        _lblInterpretation.setText("Trop maigre");
                    } else if (img > 15 && img < 21) {
                        _lblInterpretation.setText("pourcentage normal");
                    } else {
                        _lblInterpretation.setText("trop de graisse");
                    }
                }
            }
        });
    }
}