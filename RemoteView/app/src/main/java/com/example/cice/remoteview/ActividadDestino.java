package com.example.cice.remoteview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ActividadDestino extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_destino);
        Log.d("MENSAJE","Hemos entrado en la actividad destino");
    }
}
