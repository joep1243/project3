package com.example.onboarding.Vragen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onboarding.R;

public class VraagInfoscherm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vraaginfoscherm);
    }
    public void openTerug(View v) {
        Intent intent = new Intent(this, Vraagscherm.class);
        startActivity(intent);
    }
}
