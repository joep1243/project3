package com.example.onboarding.Vragen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.onboarding.Model.Code;
import com.example.onboarding.Promo.Promoscherm;
import com.example.onboarding.R;
import com.example.onboarding.helpers.VolleyHelper;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class VraagInfoscherm extends AppCompatActivity {

    private TextView txtInfo;
    private TextView txthead;
    private ImageView imgFoto;
    Code code = new Code();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vraaginfoscherm);




        txthead = findViewById(R.id.txthead);
        Getpt("Vraag", txthead );
        txtInfo = findViewById(R.id.txtInfo);
        Getpt("InfoText", txtInfo );
        imgFoto = findViewById(R.id.imgFoto);
        Getpi("Image", imgFoto );
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Vraagscherm.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_down_reverse, R.anim.slide_up_reverse);
    }

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

                    String promo = jsonObject.getString("Vraag"+Code.VID);
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
                // Locale error handling
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

                    String promo = jsonObject.getString("Vraag"+Code.VID);
                    JSONObject jsonObject1 = new JSONObject (promo);
                    String promo1 = jsonObject1.getString(finalItemi);

                    Picasso.get().load(promo1).resize(412, 161).into(finalIdi);

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


    public void openTerug(View v){
        if (code.VID < 3) {
            System.out.println(code.VID + " is vid na Nee IF");
            Intent intent = new Intent(this, Vraagscherm.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_down_reverse, R.anim.slide_up_reverse);
        } else if (code.VID == 3){
            code.VID++;
            System.out.println(code.VID + " is vid na Nee");
            Intent intent = new Intent(this, Promoscherm.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }
}
