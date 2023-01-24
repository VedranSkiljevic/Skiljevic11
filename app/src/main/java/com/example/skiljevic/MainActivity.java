package com.example.skiljevic;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner izbornik;

    EditText Unos;

    TextView USD, EUR, CHF;

    Button gumb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        izbornik=findViewById(R.id.Izbornik);
        Unos=findViewById(R.id.UnosIznosa);
        USD=findViewById(R.id.KolicinaUSD);
        EUR=findViewById(R.id.KolicinaEUR);
        CHF=findViewById(R.id.KolicinaCHF);
        gumb=findViewById(R.id.gumb1);


        String[] tecaj = {"Srednji", "Kupovni", "Prodajni"};
        ArrayAdapter ad = new ArrayAdapter<String>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item,tecaj);
        izbornik.setAdapter(ad);

        gumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double pareEUR, pareUSD, pareCHF;

                Double amount = Double.parseDouble(Unos.getText().toString());

                if(izbornik.getSelectedItem().toString() == "Srednji"){
                    pareEUR =  ((double)(amount / 7.53)*1000/1000);
                    pareUSD = ((double)(amount / 7.064)*1000/1000);
                    pareCHF = ((double)(amount / 7.65)*1000/1000);
                    EUR.setText(pareEUR.toString());
                    USD.setText(pareUSD.toString());
                    CHF.setText(pareCHF.toString());
                }

                else if (izbornik.getSelectedItem().toString() == "Kupovni"){
                    pareEUR = ((double)(amount / 7.51)*1000/1000);
                    pareUSD = ((double)(amount / 7.04)*1000/1000);
                    pareCHF = ((double)(amount / 7.63)*1000/1000);
                    EUR.setText(pareEUR.toString());
                    USD.setText(pareUSD.toString());
                    CHF.setText(pareCHF.toString());
                }
                else if (izbornik.getSelectedItem().toString() == "Prodajni"){
                    pareEUR = ((double)(amount / 7.56)*1000/1000);
                    pareUSD = ((double)(amount / 7.08)*1000/1000);
                    pareCHF = ((double)(amount / 7.67)*1000/1000);
                    EUR.setText(pareEUR.toString());
                    USD.setText(pareUSD.toString());
                    CHF.setText(pareCHF.toString());
                }
            }
        });
    }
}