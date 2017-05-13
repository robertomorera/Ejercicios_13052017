package com.example.cice.foregroundservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ReceiverStop extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.d("MENSAJE","Ha tocado el botón de stop");
        //Creamos el intent para parar el servicio.
        Intent intentService=new Intent(context,ForegroundService.class);
        intentService.setAction("STOP");
        context.startService(intentService);
    }
}
