package com.example.sherif.damakvf;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

@RequiresApi(api = Build.VERSION_CODES.M)
public class AddRequest extends AppCompatActivity {

    private EditText name,phone;
    private Spinner city,bloodType;
    public static Button add,qrCode;

    public static int count ;
    private static final int MY_CAMERA_REQUEST_CODE = 100;



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_request);


        //no horizonal
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        add = (Button) findViewById(R.id.add_add);
        qrCode = (Button) findViewById(R.id.qr_code);
        name = (EditText) findViewById(R.id.name_add);
        phone = (EditText) findViewById(R.id.phone_add);
        city = (Spinner) findViewById(R.id.city_add);
        bloodType = (Spinner) findViewById(R.id.blood_type_add);

        //permission
        if (checkSelfPermission(Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA},
                    MY_CAMERA_REQUEST_CODE);
        }

        //adapter for blood type
        ArrayAdapter<CharSequence> adapterBloodType = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.custom_blood_type, android.R.layout.simple_spinner_item);
        adapterBloodType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodType.setAdapter(adapterBloodType);

        //adapter for city
        ArrayAdapter<CharSequence> adapterCity = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.custom_city, android.R.layout.simple_spinner_item);
        adapterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        city.setAdapter(adapterCity);

        final ArrayList<Request> arrayList = SplashScreen.arrayList;

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_ = name.getText().toString();
                String phone_ = phone.getText().toString();

                if (name_.isEmpty()) {
                    name.setError("name is required");
                    name.requestFocus();
                    return;
                }
                if (phone_.isEmpty()) {
                    phone.setError("phone is required");
                    phone.requestFocus();
                    return;
                }

                Request request = new Request(name.getText().toString(), phone.getText().toString(),
                        city.getSelectedItem().toString(), bloodType.getSelectedItem().toString(), getCurrentTime());
                arrayList.add(request);
                count = count + 1;
                Toast.makeText(getApplicationContext(), "add request succesfully", Toast.LENGTH_SHORT).show();
                name.setText("");
                phone.setText("");
                add.setVisibility(View.GONE);/*
                Intent intent = new Intent(getApplicationContext(), Posts.class);
                startActivity(intent);*/
                onBackPressed();
            }


            //onBackPressed();
               /* Intent intent = new Intent(getApplicationContext(),Posts.class);
                startActivity(intent);*/
        });
        qrCode.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_DENIED) {
                    Intent intent = new Intent(getApplicationContext(), Scan.class);
                    startActivity(intent);
                } else {
                    if (checkSelfPermission(Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{Manifest.permission.CAMERA},
                                MY_CAMERA_REQUEST_CODE);
                    }
                }

            }
        });
    }
    private String getCurrentTime(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE hh:mm a");
        String date = simpleDateFormat.format(calendar.getTime());
        return date;
    }

}
