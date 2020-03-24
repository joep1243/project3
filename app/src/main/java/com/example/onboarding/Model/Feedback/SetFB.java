package com.example.onboarding.Model.Feedback;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.onboarding.helpers.VolleyHelper;

import org.json.JSONException;
import org.json.JSONObject;

public class SetFB extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    private VolleyHelper helper;
    private String vMrk1;
    private String vMrk2;
    private String vFdb;
    private String vSID;

    public void SetFB(Context Context, String sIntake, String sOpenDag, String txtFeedback, String sStudent){

        vMrk1 = sIntake;
        vMrk2 = sOpenDag;
        vFdb = txtFeedback;
        vSID = sStudent;

        helper = new VolleyHelper(Context, "https://adaonboarding.ml/t3/OnboardingAPI");
        helper.get("SetFB/indexVis.php", null, this, this);

    }
    /**
     *
     * @param error Als er een error is met het ophalen van json
     */
    @Override
    public void onErrorResponse(VolleyError error) {
        System.out.println(error);
    }

    /**
     *
     * @param response Wat er gebeurt als er json teruggegeven wordt uit de api
     */
    @Override
    public void onResponse(JSONObject response) {
        System.out.println(response.toString());

        try {
            JSONObject jsonObject = new JSONObject (response.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}



