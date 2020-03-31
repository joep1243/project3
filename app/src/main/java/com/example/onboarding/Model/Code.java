package com.example.onboarding.Model;


import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.onboarding.Promo.Promoscherm;
import com.example.onboarding.Vragen.Vraagscherm;
import com.example.onboarding.helpers.VolleyHelper;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 */

public class Code extends AppCompatActivity {
    public static int VID = 2;
    public static int iCount;
    String StudentID = "test";
    String StudentKlas = "";
    Boolean ESE = Boolean.FALSE;

    //get sid
    public String getsid(){ return StudentID; }
    //get vid
    public Integer getvid(){ return VID; }



    public void getVIDdb(Context context){

        Context Context = null;
        Context = context;
        final Context finalContext = Context;

        VolleyHelper secondHelper = new VolleyHelper(finalContext, "https://adaonboarding.ml/t3/OnboardingAPI");
        secondHelper.get("GetVID/index.php?SID=" + StudentID , null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response.toString());
                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    Integer result = Integer.parseInt(jsonObject.getString("result"));
                    VID = result;

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

    public void getCount(Context context) {

        Context Context = null;
        Context = context;
        final Context finalContext = Context;


        VolleyHelper secondHelper = new VolleyHelper(finalContext, "https://adaonboarding.ml/t3/OnboardingAPI/GetTEXT");
        secondHelper.get("index.php", null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject jsonObject = new JSONObject (response.toString());
                    String sVraag = null, sVraag1;
                    Integer teller;

                        sVraag = jsonObject.getString("Count");
                        JSONObject jsonObject1 = new JSONObject (sVraag);
                        teller = jsonObject1.getInt("count");
                        iCount = teller;
                        System.out.println(Code.iCount + " is de teller");

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

    //set the anwser
    public void Setntw(Context context, String sid, Integer vid, String ntw) {
        Context Context = null;
        String SID = null;
        Integer VID = null;
        String NTW = null;

        Context = context;
        SID = sid;
        VID = vid;
        NTW = ntw;


        final Context finalContext = Context;
        final String finalSID = SID;
        final Integer finalVID = VID;
        final String finalNTW = NTW;

        VolleyHelper secondHelper = new VolleyHelper(finalContext, "https://adaonboarding.ml/t3/OnboardingAPI");
        secondHelper.get("SetNTW/index.php?SID=" + finalSID + "&VID=" + finalVID + "&NTW=" + finalNTW , null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response.toString());
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
    }

    public void SetVIDdb(Context context, String sid, Integer vid) {
        Context Context = null;
        String SID = null;
        Integer VID = null;

        Context = context;
        SID = sid;
        VID = vid;

        final Context finalContext = Context;
        final String finalSID = SID;
        final Integer finalVID = VID;

        VolleyHelper secondHelper = new VolleyHelper(finalContext, "https://adaonboarding.ml/t3/OnboardingAPI");
        secondHelper.get("SetVID/?SID=" + finalSID + "&VID=" + finalVID , null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response.toString());
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
    }

}
