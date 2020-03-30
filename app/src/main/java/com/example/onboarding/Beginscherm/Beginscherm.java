package com.example.onboarding.Beginscherm;

import android.os.AsyncTask;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.onboarding.Vragen.Vraagscherm;

import com.example.onboarding.R;
import com.example.onboarding.helpers.VolleyHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


public class Beginscherm<$mysql_user> extends AppCompatActivity {

    private Button btnbegin;
    private android.content.Context Context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beginscherm);

        //Ik heb hier alvast student id weggehaalt
        btnbegin = (Button) findViewById(R.id.btnbegin);
        StartDB("test");
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

                    if(result =="false") {
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
                        btnbegin.setEnabled(false); }


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
