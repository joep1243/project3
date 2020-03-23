package com.example.onboarding.Model;

import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.onboarding.helpers.VolleyHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class  PromoModel extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    private VolleyHelper helper;

        public void GetPtext(){


            helper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t3/OnboardingAPI/GetTEXT");
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
            String promo1 = jsonObject1.getString("Vraag");

            //heroes.add(new Hero(heroesArray.getJSONObject(i)));

            //txtPromoVraag.setText(promo1);
            System.out.println(promo1);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
