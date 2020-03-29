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
import com.example.onboarding.Main.Vraagscherm;
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
    private EditText StudentID;
    private TextView txtwelkom;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beginscherm);

        StudentID = (EditText) findViewById(R.id.StudentID);
        btnbegin = (Button) findViewById(R.id.btnbegin);
        txtwelkom = (TextView) findViewById(R.id.txtwelkom);


