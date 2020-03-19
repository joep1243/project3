package com.example.onboarding.Promo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.onboarding.R;

public class Promoscherm extends AppCompatActivity {

    private Button btnPinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.promoscherm);
    }

    public void openinfoPromo(View v){
        Intent intent = new Intent(this, Promoinfoscherm.class);
        startActivity(intent);
    }



}
