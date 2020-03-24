package com.example.onboarding.Promo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.onboarding.R;
import com.example.onboarding.helpers.VolleyHelper;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class Promoinfoscherm extends AppCompatActivity {
    //private com.example.onboarding.Model.PromoModel PromoModel;

    private VolleyHelper helper;


        private Button btnTerug;
        private TextView txtInfo;
        private TextView txthead;
        private ImageView imgFoto;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.promoinfoscherm);

            btnTerug = findViewById(R.id.btnTerug);
            txthead = findViewById(R.id.txthead);
            Getpt("Vraag", txthead );
            txtInfo = findViewById(R.id.txtInfo);
            Getpt("InfoText", txtInfo );
            imgFoto = findViewById(R.id.imgFoto);
            Getpi("Image", imgFoto );



            //Button delay because nobody likes to read text but i'm a evil developer so they need to read the text
            btnTerug.postDelayed(new Runnable() {
                @Override
                public void run() {
                        btnTerug.setVisibility(View.VISIBLE);
                }
            }, 1000 * 15);

        }

        @Override
        public void onBackPressed() {

        }


    //Below this there are api functions they are there because android and java are both assholes and don't wanna listen . ps DON'T TOUCH THE FUNCTIONS THEY BITE
    /**
     * @param Value
     * @param idt
     */
    public void Getpt(String Value, TextView idt) {
        String item = null;
        TextView id = null;

        id = idt;
        item = Value;

        final String finalItem = item;
        final TextView finalId = id;

        VolleyHelper secondHelper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t3/OnboardingAPI/GetTEXT");
        secondHelper.get("index.php", null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONObject jsonObject = new JSONObject (response.toString());

                    String promo = jsonObject.getString("Promo");
                    JSONObject jsonObject1 = new JSONObject (promo);

                    String promo1 = jsonObject1.getString(finalItem);
                    finalId.setText(promo1);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Locale error handlin
            }
        });
    }

    /**
     * @param Value
     * @param id
     */
    public void Getpi(String Value, ImageView id) {
        String itemi = null;
        ImageView idi = null;

        idi = id;
        itemi = Value;

        final String finalItemi = itemi;
        final ImageView finalIdi = idi;

        VolleyHelper secondHelper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t3/OnboardingAPI/GetTEXT");
        secondHelper.get("index.php", null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONObject jsonObject = new JSONObject (response.toString());

                    String promo = jsonObject.getString("Promo");
                    JSONObject jsonObject1 = new JSONObject (promo);
                    String promo1 = jsonObject1.getString(finalItemi);

                    Picasso.get().load(promo1).resize(412, 161).into(finalIdi);

                    //Loading image using Picasso
                    //Picasso.get().load(promo1).into(idi);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Locale error handlin
            }
        });
    }


}
