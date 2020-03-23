package com.example.onboarding.Promo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.onboarding.Model.PromoModel;
import com.example.onboarding.R;


public class Promoscherm extends AppCompatActivity {
    private PromoModel PromoModel;



    private Button btnPinfo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.promoscherm);

        //PromoModel PromoModel = new PromoModel();

        btnPinfo = findViewById(R.id.btnPinfo);

    }

    public void openinfoPromo(View v){
        try {
            PromoModel.GetPtext();
        }catch (Exception e){

            System.out.println(e);
        }

        //Intent intent = new Intent(this, Promoinfoscherm.class);
       // startActivity(intent);
    }



}
