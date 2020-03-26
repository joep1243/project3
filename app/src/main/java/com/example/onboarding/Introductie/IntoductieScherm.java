package com.example.onboarding.Introductie;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.VolleyError;
import com.example.onboarding.R;
import com.example.onboarding.Vragen.Vraagscherm;
import com.example.onboarding.helpers.VolleyHelper;
import com.android.volley.Response;
import org.json.JSONException;
import org.json.JSONObject;


public class IntoductieScherm extends AppCompatActivity
        //implements Response.Listener<JSONObject>, Response.ErrorListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intoductiescherm);

    }
//    private VolleyHelper helper;
//    private String item;
//    public void GetPtext(Context Context, String Value)
//    {
//        item = Value;
//
//        helper = new VolleyHelper(Context, "https://adaonboarding.ml/t3/OnboardingAPI/GetTEXT");
//        helper.get("index.php", null, this, this);
/////        JSONObject jsonObject1 = new JSONObject (Introductie);
/////        String Introductie = jsonObject1.getString("Introductie");
//
//
//    }
//
//    @Override
//    public void onErrorResponse(VolleyError error)
//    {
//        System.out.println(error);
//    }
//    @Override
//    public void onResponse(JSONObject response)
//    {
//        try
//        {
//            JSONObject jsonObject = new JSONObject(response.toString());
//
//            String promo = jsonObject.getString("Introductie");
//
//        }
//        catch(JSONException e)
//        {
//            e.printStackTrace();
//        }

    public void openVragen(View v) {
        Intent intent = new Intent(this, Vraagscherm.class);
        startActivity(intent);
    }

}
