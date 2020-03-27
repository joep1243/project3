package com.example.onboarding.Vragen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.onboarding.Promo.Promoscherm;
import com.example.onboarding.R;
import com.example.onboarding.helpers.VolleyHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Vraagscherm extends AppCompatActivity {

    public static int iTeller = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vraagscherm);
        TextView txtVraag = findViewById(R.id.txtVraag);
        TextView txtVraagNummer = findViewById(R.id.txtVraagNmr);
        txtVraagNummer.setText("Vraag "+ iTeller);

        Getpt("Vraag", txtVraag );


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
                    String sVraag = null, promo1;

                    if (iTeller < 4) {
                    sVraag = jsonObject.getString("Vraag"+iTeller);
                    JSONObject jsonObject1 = new JSONObject (sVraag);

                    promo1 = jsonObject1.getString(finalItem);
                    finalId.setText(promo1);

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

    public void openInfoscherm(View v) {
        Intent intent = new Intent(this, VraagInfoscherm.class);
        startActivity(intent);

    }

    public void openPromo(View v) {
        if (iTeller < 3){
            iTeller++;
            recreate();
        }
        else {
            Intent intent = new Intent(this, Promoscherm.class);
            startActivity(intent);
        }
    }
}