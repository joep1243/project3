package com.example.onboarding.Feedback;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.onboarding.Model.Feedback.SetFB;
import com.example.onboarding.R;
import com.example.onboarding.helpers.VolleyHelper;
import org.json.JSONException;
import org.json.JSONObject;





public class Feedback extends AppCompatActivity{

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
    Boolean bIntakeOneens = Boolean.FALSE;
    Boolean bOpenEens = Boolean.FALSE;
    Boolean bOpenOneens = Boolean.FALSE;

    private VolleyHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);

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

    private TextWatcher feedbackTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String feedbackInput = txtFeedback.getText().toString().trim();

            btnNext.setEnabled(!feedbackInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    public void IntakeEens(View v) {
        System.out.println("Eens Intake");
        btnIntakeEens.setVisibility(View.INVISIBLE);
        btnIntakeOneens.setVisibility(View.INVISIBLE);
        btnOpenEens.setVisibility(View.VISIBLE);
        btnOpenOneens.setVisibility(View.VISIBLE);
        txtIntake.setVisibility(View.INVISIBLE);
        txtOpenDag.setVisibility(View.VISIBLE);
        bIntakeEens = true;

    }

    public void IntakeOneens(View v) {
        System.out.println("Oneens Intake");
        btnIntakeEens.setVisibility(View.INVISIBLE);
        btnIntakeOneens.setVisibility(View.INVISIBLE);
        btnOpenEens.setVisibility(View.VISIBLE);
        btnOpenOneens.setVisibility(View.VISIBLE);
        txtIntake.setVisibility(View.INVISIBLE);
        txtOpenDag.setVisibility(View.VISIBLE);
        iTeller=1;
        bIntakeOneens = true;
    }

    public void OpenEens(View v) {
        System.out.println("Eens Open");
        bOpenEens = true;

        if (iTeller==0){
            System.out.println("Next Screen");
            btnOpenEens.setVisibility(View.INVISIBLE);
            btnOpenOneens.setVisibility(View.INVISIBLE);
            txtOpenDag.setVisibility(View.INVISIBLE);
        }
        else {
            txtOpenVraag.setVisibility(View.VISIBLE);
            txtFeedback.setVisibility(View.VISIBLE);
            btnNext.setVisibility(View.VISIBLE);
            btnOpenEens.setVisibility(View.INVISIBLE);
            btnOpenOneens.setVisibility(View.INVISIBLE);
            txtOpenDag.setVisibility(View.INVISIBLE);
        }

    }

    public void OpenOneens(View v) {
        System.out.println("Oneens Open");
        txtOpenVraag.setVisibility(View.VISIBLE);
        txtFeedback.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.VISIBLE);
        btnOpenEens.setVisibility(View.INVISIBLE);
        btnOpenOneens.setVisibility(View.INVISIBLE);
        txtOpenDag.setVisibility(View.INVISIBLE);
        bOpenOneens = true;

    }

    public void Verder (View v) {
        TextView tvFeedback = findViewById(R.id.txtFeedback);
        String txtFeedback = tvFeedback.getText().toString();

        String sIntake = "Oneens";
        String sOpenDag = "Oneens";

        String sStudent = "test";

        if(bIntakeEens == true){
            sIntake = "Eens";
        }

        if(bOpenEens == true){
            sOpenDag = "Eens";
        }


        SetFB setFB = new SetFB();
        setFB.SetFB(getBaseContext(), sIntake, sOpenDag, txtFeedback, sStudent);
        System.out.println("Mooie verbinding");
    }
}


