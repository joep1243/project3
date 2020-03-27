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
    private static final String url = "http://localhost/phpmyadmin/db_structure.php?server=1&db=onboarding";
    private static final String user = "root";
    private static final String pass = "root";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beginscherm);

        StudentID = (EditText) findViewById(R.id.StudentID);
        btnbegin = (Button) findViewById(R.id.btnbegin);
        txtwelkom = (TextView) findViewById(R.id.txtwelkom);

//        btnbegin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
 //               if (validate()) {
//

                    // db check true/false hier

                    //SELECT * FROM studentminuutdatumvraag WHERE sID = "%s"', $SID
                    //INSERT INTO studentminuutdatumvraag VALUES(StudentID, current_timestamp(), NULL, NULL)';
                }
//            }
//        });
//    }
//    private void setupUIViews() {
//        StudentID = (EditText) findViewById(R.id.StudentID);
//        btnbegin = (Button) findViewById(R.id.btnbegin);
//    }

//    private Boolean validate( ){
//        Boolean result = false;
//        String student = StudentID.getText().toString();
//       if(student.isEmpty()) {
//            Toast.makeText(this, "Vul je student id in", Toast.LENGTH_SHORT).show();
//        }else{
//            result = true;
//        }
//        return result;


    }


//        @Override
//        protected void onPostExecute(String result) {
//            txtwelkom.setText(result);
//        }
//    }
//}
