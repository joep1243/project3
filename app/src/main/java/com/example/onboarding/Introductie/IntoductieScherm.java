package com.example.onboarding.Introductie;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import com.android.volley.VolleyError;
import com.example.onboarding.helpers.VolleyHelper;
import com.android.volley.Response;
import org.json.JSONException;
import org.json.JSONObject;


public class IntoductieScherm extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener
{
    private VolleyHelper helper;
    private String item;
    public void GetPtext(Context Context, String Value)
    {
        item = Value;

        helper = new VolleyHelper(Context, "https://adaonboarding.ml/t3/OnboardingAPI/GetTEXT");
        helper.get("index.php", null, this, this);
        JSONObject jsonObject1 = new JSONObject (Introductie);
        String Introductie = jsonObject1.getString("Introductie");


    }

    @Override
    public void onErrorResponse(VolleyError error)
    {
        System.out.println(error);
    }
    @Override
    public void onResponse(JSONObject response)
    {
        try
        {
            JSONObject jsonObject = new JSONObject(response.toString());

            String promo = jsonObject.getString("Introductie");

        }
    }
        catch(JSONException e)
    {
        e.printStackTrace();
    }
}
