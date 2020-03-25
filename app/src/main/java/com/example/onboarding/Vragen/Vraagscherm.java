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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.onboarding.Promo.Promoscherm;
import com.example.onboarding.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Vraagscherm extends AppCompatActivity {
    private TextView jsonResultaat;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vraagscherm);

        jsonResultaat = findViewById(R.id.txtVraag);
        Button btnTest = findViewById(R.id.btnTest);
        mQueue = Volley.newRequestQueue(this);

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
    }

    private void jsonParse() {
        String url = "https://adaonboarding.ml/t3/OnboardingAPI/GetTEXT";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("vragen");

                            for (int i = 0; i< jsonArray.length(); i++){
                                JSONObject vraag = jsonArray.getJSONObject(i);
                                String vraagID = vraag.getString("ID");
                                String vraagVraag = vraag.getString("Vraag");
                                String vraagInfoText = vraag.getString("InfoText");

                                jsonResultaat.setText(vraagVraag);
                                System.out.println(vraagVraag);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            System.out.println("luktniet tryCatch");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("luktniet ErrorResponse");
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }

    public void openInfoscherm(View v) {
        Intent intent = new Intent(this, Infoscherm.class);
        startActivity(intent);
    }

    public void openPromo(View v) {
//        Intent intent = new Intent(this, Promoscherm.class);
//        startActivity(intent);
    }
}