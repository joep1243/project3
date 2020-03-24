package com.example.onboarding.Beginscherm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.onboarding.R;
import com.example.onboarding.helpers.VolleyHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Beginscherm extends AppCompatActivity {

    private Button btnbegin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beginscherm);


    }
}
