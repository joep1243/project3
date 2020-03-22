package com.example.onboarding.Promo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.onboarding.R;

public class Promoinfoscherm extends AppCompatActivity {

        private Button btnTerug;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.promoinfoscherm);

            btnTerug = findViewById(R.id.btnTerug);

            btnTerug.postDelayed(new Runnable() {
                @Override
                public void run() {
                        btnTerug.setVisibility(View.VISIBLE);
                }
            }, 1000 * 15);

        }




}
