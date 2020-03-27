package com.example.onboarding.Introductie;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.VolleyError;
import com.example.onboarding.Feedback.Feedback;
import com.example.onboarding.R;
import com.example.onboarding.Vragen.Vraagscherm;

import com.example.onboarding.helpers.VolleyHelper;
import com.android.volley.Response;
import org.json.JSONException;
import org.json.JSONObject;


public class IntoductieScherm extends AppCompatActivity

{
    private VolleyHelper helper;
    private TextView txtIntroVraag;
    private TextView txtIntroText;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intoductie_scherm);

        txtIntroVraag = findViewById(R.id.txtIntroVraag);
        GetIT("Vraag", txtIntroVraag);
        txtIntroText = findViewById(R.id.txtIntroText);
        GetIT("InfoText", txtIntroText );

    }
    public void GetIT(String Value, TextView idt) {
        String item = null;
        TextView id = null;

        id = idt;
        item = Value;

        final String finalItem = item;
        final TextView finalId = id;

        VolleyHelper helper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t3/OnboardingAPI/GetTEXT");
                helper.get("index.php", null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            JSONObject jsonObject = new JSONObject (response.toString());

                            String introductie = jsonObject.getString("Introductie");
                            System.out.println(introductie);
                            JSONObject jsonObject1 = new JSONObject (introductie);
                            String intro1 = jsonObject1.getString(finalItem);
                            finalId.setText(intro1);

        //implements Response.Listener<JSONObject>, Response.ErrorListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intoductiescherm);

    }


    public void openFeedback(View v) {
        Intent intent = new Intent(this, Feedback.class);
        startActivity(intent);
    }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Locale error handling
                    }
                });
    }
}

