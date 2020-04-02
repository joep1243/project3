package com.example.onboarding.Feedback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.onboarding.Eindscherm.Eindscherm;
import com.example.onboarding.Model.Code;
import com.example.onboarding.R;
import com.example.onboarding.Vragen.Vraagscherm;
import com.example.onboarding.helpers.VolleyHelper;
import org.json.JSONException;
import org.json.JSONObject;


public class Feedback extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

        //Objecten aanmaken
        private Button btnIntakeEens;
        private Button btnIntakeOneens;
        private Button btnOpenEens;
        private Button btnOpenOneens;
        private Button btnNext;
        private TextView txtFeedback;
        private TextView txtIntake;
        private TextView txtOpenDag;
        private TextView txtOpenVraag;
        private int iTeller = 0;
        Boolean bIntakeEens = Boolean.FALSE;
        Boolean bOpenEens = Boolean.FALSE;

        Code code = new Code();

        private VolleyHelper helper;


    /**
     * @param savedInstanceState
     */
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.feedback);

            //Objecten koppelen aan layout objecten
            btnIntakeEens = findViewById(R.id.btnIntakeEens);
            btnIntakeOneens = findViewById(R.id.btnIntakeOneens);
            btnOpenEens = findViewById(R.id.btnOpenEens);
            btnOpenOneens = findViewById(R.id.btnOpenOneens);
            btnNext = findViewById(R.id.btnNext);
            txtFeedback = findViewById(R.id.txtFeedback);
            txtIntake = findViewById(R.id.txtIntake);
            txtOpenDag = findViewById(R.id.txtOpendag);
            txtOpenVraag = findViewById(R.id.txtOpenVraag);
            txtFeedback.addTextChangedListener(feedbackTextWatcher);

        }

    /**
     *  Stopt de onBackPressed
     */
        public void onBackPressed(){
            Toast.makeText(getApplicationContext(), "Je kan niet terug", Toast.LENGTH_SHORT).show();
        }

        //Functie die btnNext niet klikbaar maakt wanneer txtFeedback leeg is
        private TextWatcher feedbackTextWatcher = new TextWatcher() {
            /**
             * @param s
             * @param start
             * @param count
             * @param after
             */
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            /**
             * @param s
             * @param start
             * @param before
             * @param count
             */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String feedbackInput = txtFeedback.getText().toString().trim();

                btnNext.setEnabled(!feedbackInput.isEmpty());
            }

            /**
             * @param s
             */
            @Override
            public void afterTextChanged(Editable s) {

            }
        };

    /** Button press maakt buttons en vraag van vraag 1 onzichtbaar en haalt vraag 2 tevoorschijn
        BIntakeEens wordt true
     * @param v
     */

        public void IntakeEens(View v) {
            btnIntakeEens.setVisibility(View.INVISIBLE);
            btnIntakeOneens.setVisibility(View.INVISIBLE);
            btnOpenEens.setVisibility(View.VISIBLE);
            btnOpenOneens.setVisibility(View.VISIBLE);
            txtIntake.setVisibility(View.INVISIBLE);
            txtOpenDag.setVisibility(View.VISIBLE);
            bIntakeEens = true;

        }

    /** Button press maakt buttons en vraag van vraag 1 onzichtbaar en haalt vraag 2 tevoorschijn
     * @param v
     */

        public void IntakeOneens(View v) {
            btnIntakeEens.setVisibility(View.INVISIBLE);
            btnIntakeOneens.setVisibility(View.INVISIBLE);
            btnOpenEens.setVisibility(View.VISIBLE);
            btnOpenOneens.setVisibility(View.VISIBLE);
            txtIntake.setVisibility(View.INVISIBLE);
            txtOpenDag.setVisibility(View.VISIBLE);


        }

    /** Button press maakt buttons en vraag van vraag 2 onzichtbaar en haalt de open vraag tevoorschijn
        BOpenEens wordt true
     * @param v
     */

        public void OpenEens(View v) {
            txtOpenVraag.setVisibility(View.VISIBLE);
            txtFeedback.setVisibility(View.VISIBLE);
            btnNext.setVisibility(View.VISIBLE);
            btnOpenEens.setVisibility(View.INVISIBLE);
            btnOpenOneens.setVisibility(View.INVISIBLE);
            txtOpenDag.setVisibility(View.INVISIBLE);
            bOpenEens = true;

        }

    /** Button press maakt buttons en vraag van vraag 2 onzichtbaar en haalt de open vraag tevoorschijn
     * @param v
     */
        public void OpenOneens(View v) {
            System.out.println("Oneens Open");
            txtOpenVraag.setVisibility(View.VISIBLE);
            txtFeedback.setVisibility(View.VISIBLE);
            btnNext.setVisibility(View.VISIBLE);
            btnOpenEens.setVisibility(View.INVISIBLE);
            btnOpenOneens.setVisibility(View.INVISIBLE);
            txtOpenDag.setVisibility(View.INVISIBLE);
        }

    /** Checkt de Booleans om t weten welke variabele hij moet doorsturen
        Submit Feedback
     * @param v
     */

        public void Verder(View v) {
            TextView tvFeedback = findViewById(R.id.txtFeedback);
            String txtFeedback = tvFeedback.getText().toString();

            String sIntake = "Oneens";
            String sOpenDag = "Oneens";

            String sStudent = "test";

            if (bIntakeEens == true) {
                sIntake = "Eens";
            }

            if (bOpenEens == true) {
                sOpenDag = "Eens";
            }

            //API functie SetFB aanspreken
            helper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t3/OnboardingAPI");
            helper.get("SetFB/indexVis.php?SID=" + sStudent + "&mrk1=" + sIntake + "&mrk2=" + sOpenDag + "&fdb=" + txtFeedback, null, this, this);

            //Open Eindscherm
            Code.VID++;
            System.out.println(Code.VID);
            Intent intent = new Intent(this, Eindscherm.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        }


    /**
     * @param error Bij een error van het terug geven van de JSON
     */

        @Override
        public void onErrorResponse(VolleyError error) {
            System.out.println(error);
        }


    /** Wanneer er een JSON wordt teruggestuurd vanuit de API
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





