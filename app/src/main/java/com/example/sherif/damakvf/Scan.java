package com.example.sherif.damakvf;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Scan extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    ZXingScannerView zXingScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        zXingScannerView = new ZXingScannerView(this);
        setContentView(zXingScannerView);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void handleResult(Result result) {

        String x[] = {"sherif","mohamed","ahmed"};
        for (int i = 0 ; i<x.length ; i++){
            if (result.getText().equalsIgnoreCase(x[i])){
                AddRequest.add.setVisibility(View.VISIBLE);
                break;
            }
        }
        //MainActivity.tx_qr_result.setText(result.getText());
        Toast.makeText(getApplicationContext(),"yes",Toast.LENGTH_SHORT);
        onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        zXingScannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();

        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();
    }
}
