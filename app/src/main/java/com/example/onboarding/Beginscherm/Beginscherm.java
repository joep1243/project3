package com.example.onboarding.Beginscherm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.onboarding.Model.Code;
import com.example.onboarding.R;
import com.example.onboarding.Vragen.Vraagscherm;
import com.example.onboarding.helpers.VolleyHelper;

import org.json.JSONException;
import org.json.JSONObject;


public class Beginscherm<$mysql_user> extends AppCompatActivity {

    private Button btnbegin;
    private android.content.Context Context;
    Code code = new Code();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beginscherm);

        //Ik heb hier alvast student id weggehaalt
        btnbegin = (Button) findViewById(R.id.btnbegin);
        StartDB("test");
        code.getVIDdb(getBaseContext());
    }

    public void openVragen(View v) {
        Intent intent = new Intent(this, Vraagscherm.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    //i Don't know why this works but it does it's some Demon Shit
    public void StartDB(String sid) {

        String SID = null;

        SID = sid;

        final String finalSID = SID;

        VolleyHelper secondHelper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t3/OnboardingAPI");
        secondHelper.get("GetSID/index.php?SID=" + finalSID , null, new Response.Listener<JSONObject>() {

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

                    }else {

                        //hier nog toast
                        //============================================================
                        //
                        btnbegin.setEnabled(true); }// DEBUG deze moet dadelijk of false


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
