package com.example.sherif.damakvf;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Posts extends AppCompatActivity {

    private ListView listView;
    public static Spinner cityF,bloodTypeF;
    private FloatingActionButton floatingActionButton;
    private RequestAdapter requestAdapter;
    private Request request;
    private ImageView search;
    public static String city_send = "All";
    public static String blood_send = "All";

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        //no horizonal
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        listView = (ListView) findViewById(R.id.list);
        cityF = (Spinner) findViewById(R.id.city_posts);
        bloodTypeF = (Spinner) findViewById(R.id.blood_type_posts);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.add);
        search = (ImageView) findViewById(R.id.search_img);



        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                city_send = cityF.getSelectedItem().toString();
                blood_send = bloodTypeF.getSelectedItem().toString();
                finish();
                startActivity(new Intent(getApplicationContext(), Posts.class));
                overridePendingTransition(0, 0);

            }
        });

        if (AddRequest.count>=1){

            //requestAdapter.notifyDataSetChanged();

        ArrayList<Request> arrayList = SplashScreen.arrayList;
        Collections.reverse(arrayList);
        requestAdapter = new RequestAdapter(this,R.layout.request,arrayList);
        requestAdapter.notifyDataSetChanged();
        listView.setAdapter(requestAdapter);
        }else {
            Toast.makeText(getApplicationContext(),"please add request",Toast.LENGTH_SHORT).show();
        }

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AddRequest.class);
                startActivity(intent);
            }
        });
        //adapter for blood type
        ArrayAdapter<CharSequence> adapterBloodType = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.blood_type,android.R.layout.simple_spinner_item);
        adapterBloodType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodTypeF.setAdapter(adapterBloodType);

        //adapter for city
        ArrayAdapter<CharSequence> adapterCity = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.city,android.R.layout.simple_spinner_item);
        adapterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cityF.setAdapter(adapterCity);


    }

}
