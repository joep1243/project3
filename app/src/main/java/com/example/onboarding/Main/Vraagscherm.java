package com.example.onboarding.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.onboarding.R;

public class Vraagscherm extends AppCompatActivity {

    private Button jaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vraagscherm);
    }

    public void openInfoscherm(View v) {
        Intent intent = new Intent(this, VolgendScherm.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}