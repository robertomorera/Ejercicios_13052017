package com.example.cice.seleccionarfechahora;


import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*DialogFragment fragmentCalendario=new CalendarioDialog();
        fragmentCalendario.show(getSupportFragmentManager(),"calendario");
        */

        DialogFragment fragmentHora=new HoraDialog();
        fragmentHora.show(getSupportFragmentManager(),"horario");




    }
}


