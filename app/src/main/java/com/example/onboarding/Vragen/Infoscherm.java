package com.example.onboarding.Vragen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onboarding.R;

public class Infoscherm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infoscherm);
    }
    public void openTerug(View v) {
        Intent intent = new Intent(this, Vraagscherm.class);
        startActivity(intent);
    }
}
