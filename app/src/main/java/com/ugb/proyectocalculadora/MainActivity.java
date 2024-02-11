package com.ugb.proyectocalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

TabHost tbh;

TextView TempVal;
Spinner spn;
Button btn;

conversores miObj = new conversores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbh = findViewById(R.id.tbhConversores);
        tbh.setup();

        tbh.addTab(tbh.newTabSpec( "LONG").setContent(R.id.tabLongitud).setIndicator("LONGITUD", null));
        tbh.addTab(tbh.newTabSpec( "ALM").setContent(R.id.tabAlmacenamiento).setIndicator("ALMACENAMIENTO", null));
        tbh.addTab(tbh.newTabSpec( "MON").setContent(R.id.tabMonedas).setIndicator("MONEDAS", null));

        btn=findViewById(R.id.btnConvertirLongitud);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spn = findViewById(R.id.spnALongitud);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnDeLongitud);
                int a = spn.getSelectedItemPosition();


                TempVal = findViewById(R.id.txtCantidadLongitud);
                double cantidad = Double.parseDouble(TempVal.getText().toString());

                double respuesta = miObj.convertir(0, de, a, cantidad);
                Toast.makeText(getApplicationContext(), "Respuesta: " + respuesta, Toast.LENGTH_LONG).show();
            }
        });

        btn=findViewById(R.id.btnConvertirAlmacenamiento);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                spn=findViewById(R.id.spnDeAlmacenamiento);
                int de = spn.getSelectedItemPosition();

                spn=findViewById(R.id.spnAAlmacenamiento);
                int a = spn.getSelectedItemPosition();

                TempVal = findViewById(R.id.txtCantidadAlmacenamiento);
                double cantidad = Double.parseDouble(TempVal.getText().toString());

                double respuesta = miObj.convertir(1, de, a, cantidad);
                Toast.makeText(getApplicationContext(), "Respuesta: " + respuesta, Toast.LENGTH_LONG).show();

            }
        });


        btn= findViewById(R.id.btnConvertirMonedas);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                spn = findViewById(R.id.spnAMonedas);
                int a = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnDeMonedas);
                int de = spn.getSelectedItemPosition();

                TempVal = findViewById(R.id.txtCantidadMonedas);
                double cantidad = Double.parseDouble(TempVal.getText().toString());

                double respuesta= miObj.convertir(2, de ,a ,cantidad);
                Toast.makeText(getApplicationContext(), "Respuesta "+ respuesta, Toast.LENGTH_LONG).show();

            }
        });


    }
}
class conversores{
    double [][] valores ={
            {1, 100, 39.37, 3.28, 1.193, 1.09361, 0.001,0.000621371},
            {0.000001, 0.001, 1, 1000, 1000000,1000000000},
            {1,1.08,0.058,0.0067,1.26,0.13,0.041,0.027},
    };
    public double convertir (int opcion, int de, int a, double cantidad){
        return valores[opcion][de]*cantidad/valores[opcion][a];
    }
}