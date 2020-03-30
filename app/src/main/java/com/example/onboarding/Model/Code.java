package com.example.onboarding.Model;


import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.onboarding.helpers.VolleyHelper;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 */

public class Code extends AppCompatActivity {

    String StudentID = "test";
    String StudentKlas = "";
    Integer VID = 1;
    Boolean ESE = Boolean.FALSE;


    //get sid
    public String getsid(){ return StudentID; }
    //get vid
    public Integer getvid(){ return VID; }



    public void Next(Context context){


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
                    Integer result = jsonObject.getInt("vID");

                    if(result == VID){

                        //hier ga je verder als ze gelijk zijn

                    }else{

                        //hier gga je verder als ze niet gelijk zijn

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

}
