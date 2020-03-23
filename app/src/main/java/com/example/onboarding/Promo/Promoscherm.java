package com.example.onboarding.Promo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
        try {
            PromoModel.GetPtext();
        }catch (Exception e){

            System.out.println(e);
        }
    }

    public void openinfoPromo(View v){
        try {

            /*Intent i = new Intent(Intent.ACTION_SENDTO);
            i.setType("message/rfc822");
            i.setData(Uri.parse("mailto: luuk.witters@gmail.com"));
            //i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@example.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, "Test mail");
            i.putExtra(Intent.EXTRA_TEXT   , "kan nu mailen via de app");
            try {
                startActivity(Intent.createChooser(i, "Send mail..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(Promoscherm.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }*/

            PromoModel.GetPtext();
        }catch (Exception e){

            System.out.println(e);
        }

        //Intent intent = new Intent(this, Promoinfoscherm.class);
       // startActivity(intent);
    }



}
