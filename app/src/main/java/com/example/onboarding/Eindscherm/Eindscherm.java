package com.example.onboarding.Eindscherm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.onboarding.Model.Code;
import com.example.onboarding.R;
import com.example.onboarding.helpers.VolleyHelper;

import org.json.JSONException;
import org.json.JSONObject;

public class Eindscherm extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    //Objecten Aanmaken
    private Button btnEind;
    private VolleyHelper helper;
    private String sStudent;
    Code code = new Code();

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eindscherm);
        sStudent = code.getsid();
    }

    /** Functie om de app te 'Beëindigen' en Einddatum te setten in Database
     * @param v
     */
    public void eindApp(View v)
    {
        Toast.makeText(this, "Eind Onboarding", Toast.LENGTH_LONG).show();

        helper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t3/OnboardingAPI");
        helper.get("SetEDT/index.php?SID=" + sStudent, null, this, this);

    }

    /**
     * @param error
     */
    @Override
    public void onErrorResponse(VolleyError error) {
        code.toast(getApplicationContext());
    }




    /** response Wat er gebeurt als er json teruggegeven wordt uit de api
     * @param response
     */
    @Override
    public void onResponse(JSONObject response) {
        System.out.println(response.toString());
        try {
            JSONObject jsonObject = new JSONObject(response.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
