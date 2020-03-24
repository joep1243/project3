package com.example.onboarding.Vragen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onboarding.Promo.Promoscherm;
import com.example.onboarding.R;

public class Vraagscherm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vraagscherm);
    }

    public void openInfoscherm(View v) {
        Intent intent = new Intent(this, Infoscherm.class);
        startActivity(intent);
    }

    public void openPromo(View v) {
        Intent intent = new Intent(this, Promoscherm.class);
        startActivity(intent);
    }
}