package com.example.onboarding.Vragen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.onboarding.Beginscherm.Beginscherm;
import com.example.onboarding.Promo.Promoscherm;
import com.example.onboarding.R;
import com.example.onboarding.helpers.VolleyHelper;

import org.json.JSONException;
import org.json.JSONObject;

public class Vraagscherm extends AppCompatActivity {

    public static int iTeller = 1;
    public int iTotaalAantalVragen = 3; // erg belangrijk, zo weet het programma of het doormoet naar de volgende vraag of het volgende scherm
    public String sAntwoord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vraagscherm);
        TextView txtVraag = findViewById(R.id.txtVraag);
        TextView txtVraagNummer = findViewById(R.id.txtVraagNmr);
        txtVraagNummer.setText("Vraag "+ iTeller);

        Getpt("Vraag", txtVraag);

    }
    /**
     * @param Value
     * @param idt
     */
    public void Getpt(String Value, TextView idt) {
        String item = null;
        TextView id = null;

        id = idt;
        item = Value;

        final String finalItem = item;
        final TextView finalId = id;

        VolleyHelper secondHelper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t3/OnboardingAPI/GetTEXT");
        secondHelper.get("index.php", null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject jsonObject = new JSONObject (response.toString());
                    String sVraag = null, promo1, promo2;

                    if (iTeller <= iTotaalAantalVragen) {
                    sVraag = jsonObject.getString("Vraag"+iTeller);
                    JSONObject jsonObject1 = new JSONObject (sVraag);
                    JSONObject jsonObject2 = new JSONObject (sVraag);

                    promo1 = jsonObject1.getString(finalItem);
                    finalId.setText(promo1);
                    sAntwoord = jsonObject2.getString("Antwoord");

                    sAntwoord = jsonObject2.getString("Antwoord");
                    }

                    else {
                        Intent i = new Intent(Vraagscherm.this, Promoscherm.class);
                        startActivity(i);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Locale error handlin
            }
        });


    }

    public void openJa(View v) {
        System.out.println(sAntwoord + " is het ingevoerde antwoord");
        if (sAntwoord.equals("ja")) {
            Intent intent = new Intent(this, VraagInfoscherm.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
        } else if (sAntwoord.equals("nee")) {
            if (iTeller < iTotaalAantalVragen) {
                iTeller++;
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                startActivity(getIntent());
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            } else if (iTeller == iTotaalAantalVragen){
                Intent intent = new Intent(this, Promoscherm.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        }
    }

    public void openNee(View v) {
        System.out.println(sAntwoord + " is het ingevoerde antwoord");
        if (sAntwoord.equals("nee")) {
            Intent intent = new Intent(this, VraagInfoscherm.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
        } else if (sAntwoord.equals("ja")) {
            if (iTeller < iTotaalAantalVragen) {
                iTeller++;
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                startActivity(getIntent());
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            } else if (iTeller == iTotaalAantalVragen){
                Intent intent = new Intent(this, Promoscherm.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        }
    }

    @Override
    public void onBackPressed(){
        if (iTeller == 1){
            Intent i = new Intent(Vraagscherm.this, Beginscherm.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
        else{
        iTeller--;
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            startActivity(getIntent());
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }
}