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

    private Button btnEind;
    private VolleyHelper helper;
    private String sStudent;
    Code code = new Code();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eindscherm);
        sStudent = code.getsid();
        btnEind = (Button) findViewById(R.id.btnEind);
    }

    public void eindApp(View v)
    {
        Toast.makeText(this, "Eind Onboarding", Toast.LENGTH_LONG).show();

        helper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t3/OnboardingAPI");
        helper.get("SetEDT/index.php?SID=" + sStudent, null, this, this);

        this.btnEind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    /**
     * @param error Als er een error is met het ophalen van json
     */
    @Override
    public void onErrorResponse(VolleyError error) {
        System.out.println(error);
        //Tosti
    }

    /**
     * @param response Wat er gebeurt als er json teruggegeven wordt uit de api
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
