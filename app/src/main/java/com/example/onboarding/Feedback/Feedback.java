package com.example.onboarding.Feedback;

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

public class Feedback extends AppCompatActivity {

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
    }

    public void OpenEens(View v) {
        System.out.println("Eens Open");

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
        }

    public void Verder (View v) {
        System.out.println("Button works");
    }

}


