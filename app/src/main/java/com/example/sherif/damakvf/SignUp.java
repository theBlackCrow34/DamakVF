package com.example.sherif.damakvf;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    private Button signUp;
    private Spinner city,bloodType;
    private String c,v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //no horizonal
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        city = (Spinner) findViewById(R.id.city_sign_up);
        bloodType = (Spinner) findViewById(R.id.blood_type_sign_up);
        signUp = (Button) findViewById(R.id.sign_up_sign_up);

        //adapter for blood type
        ArrayAdapter<CharSequence> adapterBloodType = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.custom_blood_type,android.R.layout.simple_spinner_item);
        adapterBloodType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodType.setAdapter(adapterBloodType);

        //adapter for city
        ArrayAdapter<CharSequence> adapterCity = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.custom_city,android.R.layout.simple_spinner_item);
        adapterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        city.setAdapter(adapterCity);



        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c = bloodType.getSelectedItem().toString() ;
                v = city.getSelectedItem().toString() ;
                Toast.makeText(getApplicationContext(),c+v,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
