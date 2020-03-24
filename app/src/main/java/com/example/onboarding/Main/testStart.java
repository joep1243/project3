package com.example.onboarding.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.onboarding.R;
import com.example.onboarding.Vragen.Vraagscherm;

public class testStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teststart);
    }

    public void openVragen(View v) {
        Intent intent = new Intent(this, Vraagscherm.class);
        startActivity(intent);
    }
}
