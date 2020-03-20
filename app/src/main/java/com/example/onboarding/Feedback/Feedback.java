package com.example.onboarding.Feedback;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.onboarding.R;

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

    }

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
    }

    public void OpenEens(View v) {
        System.out.println("Eens Open");
        btnOpenEens.setVisibility(View.INVISIBLE);
        btnOpenOneens.setVisibility(View.INVISIBLE);
        txtFeedback.setVisibility(View.VISIBLE);
        txtOpenDag.setVisibility(View.INVISIBLE);
        txtOpenVraag.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.VISIBLE);
    }

    public void OpenOneens(View v) {
        System.out.println("Oneens Open");
        btnOpenEens.setVisibility(View.INVISIBLE);
        btnOpenOneens.setVisibility(View.INVISIBLE);
        txtFeedback.setVisibility(View.VISIBLE);
        txtOpenDag.setVisibility(View.INVISIBLE);
        txtOpenVraag.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.VISIBLE);
    }

    public void Verder (View v) {
        System.out.println("Button works");
    }


}
