package com.example.onboarding.Vragen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.example.onboarding.Promo.Promoscherm;
import com.example.onboarding.R;

public class Vraagscherm extends AppCompatActivity {
    private TextView jsonResultaat;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vraagscherm);

        jsonResultaat = findViewById(R.id.txtVraag);
        Button btnTest = findViewById(R.id.btnTest);

    }


    public void openInfoscherm(View v) {
        Intent intent = new Intent(this, VraagInfoscherm.class);
        startActivity(intent);
    }

    public void openPromo(View v) {
       Intent intent = new Intent(this, Promoscherm.class);
       startActivity(intent);
    }
}