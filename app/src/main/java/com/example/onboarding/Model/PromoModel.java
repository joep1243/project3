package com.example.onboarding.Model;

import android.content.Context;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.onboarding.helpers.VolleyHelper;

import org.json.JSONException;
import org.json.JSONObject;

public class  PromoModel extends AppCompatActivity{
    private VolleyHelper helper;
        private String item;
            private String test;

  /*  public String Getp(Context Context, String Value) {

        item = Value;

        VolleyHelper secondHelper = new VolleyHelper(Context, "https://adaonboarding.ml/t3/OnboardingAPI/GetTEXT");
        secondHelper.get("index.php", null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONObject jsonObject = new JSONObject (response.toString());

                    String promo = jsonObject.getString("Promo");
                    JSONObject jsonObject1 = new JSONObject (promo);

                    String promo1 = jsonObject1.getString(item);

                    test = promo1;


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
        return test ;
    }


        public void GetPtext(Context Context, String Value){

            item = Value;

            helper = new VolleyHelper(Context, "https://adaonboarding.ml/t3/OnboardingAPI/GetTEXT");
            helper.get("index.php", null, this, this);


        }


    @Override
    public void onErrorResponse(VolleyError error) { System.out.println(error); }

    @Override
    public void onResponse(JSONObject response) {
        try {

            JSONObject jsonObject = new JSONObject (response.toString());

            String promo = jsonObject.getString("Promo");
            JSONObject jsonObject1 = new JSONObject (promo);

            String promo1 = jsonObject1.getString(item);

            //heroes.add(new Hero(heroesArray.getJSONObject(i)));

           // txtPromoVraag.setText(promo1);

            //System.out.println(promo1);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }*/






}
