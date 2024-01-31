package com.ugb.proyectocalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView num;
    TextView resp;
    Button btnCalc;
    Button btnCalc2;
    RadioGroup opt;

    Spinner spnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalc2 = findViewById(R.id.btnCalcular2);
        btnCalc = findViewById(R.id.btnCalcular);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                num = findViewById(R.id.txtNum1);
                double num1 = Double.parseDouble(num.getText().toString());

                num = findViewById(R.id.txtNum2);
                double num2 = Double.parseDouble(num.getText().toString());

                double respuesta = 0;

                opt = findViewById(R.id.radioOpciones);
                spnCalc = findViewById(R.id.spnOpciones);

                int checkedRadioButtonId = opt.getCheckedRadioButtonId();
                if (checkedRadioButtonId == R.id.suma) {
                    respuesta = num1 + num2;
                } else if (checkedRadioButtonId == R.id.btnRESTA) {
                    respuesta = num1 - num2;
                } else if (checkedRadioButtonId == R.id.btnMULTI) {
                    respuesta = num1 * num2;
                } else if (checkedRadioButtonId == R.id.btnDIV) {
                    respuesta = num1 / num2;
                } else if (checkedRadioButtonId == R.id.btnPERCENT) {
                    respuesta = num1 - (num1 * (num2/100));
                } else if (checkedRadioButtonId == R.id.btnEXPO) {
                    respuesta = Math.pow(num1,num2);
                } else if (checkedRadioButtonId == R.id.btnFACTO) {
                    for (int i = 2; i <= num1; i++) {
                        respuesta+=num1*i;
                    }
                } else if (checkedRadioButtonId == R.id.btnRAIZ) {
                    respuesta = Math.round(Math.pow(num1, 1.0 / num2));
                }
                
                num = findViewById(R.id.lblRespuesta);
                num.setText("Respuesta: "+ respuesta);
            }
        });

        btnCalc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                num = findViewById(R.id.txtNum1);
                double num1 = Double.parseDouble(num.getText().toString());

                num = findViewById(R.id.txtNum2);
                double num2 = Double.parseDouble(num.getText().toString());

                double respuesta = 0;

                switch (spnCalc.getSelectedItemPosition()){
                    case 0:
                        respuesta = num1 + num2;
                    break;
                    case 1:
                        respuesta = num1 - num2;
                        break;
                    case 2:
                        respuesta = num1 * num2;
                        break;
                    case 3:
                        respuesta = num1 / num2;
                        break;
                    case 4:
                        respuesta = num1 - (num1 * (num2/100));
                        break;
                    case 5:
                        respuesta = Math.pow(num1,num2);
                        break;
                    case 6:
                        for (int i = 2; i <= num1; i++) {
                            respuesta+=num1*i;
                        }
                        break;
                    case 7:
                        respuesta= Math.round(Math.pow(num1, 1.0 / num2));

                        break;
                }

                num = findViewById(R.id.lblRespuesta);
                num.setText("Respuesta: " + respuesta);

            }
        });



    }
}