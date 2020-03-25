package com.example.onboarding.Model;

import android.content.Context;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.onboarding.helpers.VolleyHelper;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.onboarding.R;

public class  VragenModel extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    private VolleyHelper helper;
    private String item;

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

            String vraag = jsonObject.getString("vragen");
            JSONObject jsonObject1 = new JSONObject (vraag);

            String vraag1 = jsonObject1.getString(item);

            //heroes.add(new Hero(heroesArray.getJSONObject(i)));

            // txtPromoVraag.setText(promo1);

            System.out.println(vraag1);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
