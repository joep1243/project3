package com.example.onboarding.Beginscherm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.example.onboarding.Feedback.Feedback;
import com.example.onboarding.Introductie.IntoductieScherm;
import com.example.onboarding.Model.Code;
import com.example.onboarding.Promo.Promoscherm;

import com.example.onboarding.Model.Code;

import com.example.onboarding.R;
import com.example.onboarding.Vragen.Vraagscherm;
import com.example.onboarding.helpers.VolleyHelper;

import org.json.JSONException;
import org.json.JSONObject;



    private Button btnbegin;
    private android.content.Context Context;
    Code code = new Code();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beginscherm);


        //Ik heb hier alvast student id weggehaalt
        btnbegin = (Button) findViewById(R.id.btnbegin);

        StartDB("waltertest");
        code.getVIDdb(getBaseContext());
        code.getCount(getBaseContext());
    }

    public void openVragen(View v) {
        if(Code.VID <= Code.iCount) {
            Intent intent = new Intent(this, Vraagscherm.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

        else if (Code.VID == Code.iCount + 1){
            Intent intent = new Intent(this, Promoscherm.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        else if (Code.VID == 100){
            Intent intent = new Intent(this, IntoductieScherm.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        else if (Code.VID == 101){
            Intent intent = new Intent(this, Feedback.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }

    //i Don't know why this works but it does it's some Demon Shit
    public void StartDB(final String sid) {

        String SID = null;

        SID = sid;

        final String finalSID = SID;

        VolleyHelper secondHelper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t3/OnboardingAPI");
        secondHelper.get("GetSID/index.php?SID=" + finalSID, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    String result = jsonObject.getString("result");

                    if(result.equals("false")) {
                        VolleyHelper secondHelper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t3/OnboardingAPI");
                        secondHelper.get("StartDB/index.php?SID=" + finalSID, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {

                                //set sid in code file
                                code.setsid(finalSID);
                                //System.out.println(response.toString());

                                try {
                                    JSONObject jsonObject = new JSONObject(response.toString());

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

                    }else {

                        //hier nog toast
                        //============================================================
                        //
                        btnbegin.setEnabled(true); }// DEBUG deze moet dadelijk of false


                } catch (JSONException e) {
                    e.printStackTrace();
                }

}

