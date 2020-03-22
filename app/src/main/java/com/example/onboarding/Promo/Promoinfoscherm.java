package com.example.onboarding.Promo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.onboarding.R;

import java.util.Timer;
import java.util.TimerTask;

public class Promoinfoscherm extends AppCompatActivity {


        Timer timer;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.promoscherm);

            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {

                    //startActivity();
                    finish();
                }
            }, 5000);
        }




}
