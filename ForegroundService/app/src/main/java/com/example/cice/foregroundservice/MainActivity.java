package com.example.cice.foregroundservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }


    public void iniciarServicio(View v){

        Intent intentService=new Intent(this,ForegroundService.class);
        intentService.setAction("START");
        startService(intentService);
    }

    public void pararServicio(View v){

        Intent intentService=new Intent(this,ForegroundService.class);
        intentService.setAction("STOP");
        startService(intentService);
    }

}
