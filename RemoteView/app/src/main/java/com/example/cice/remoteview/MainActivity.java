package com.example.cice.remoteview;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //PREPARO LA VISTA DE LA NOTIFICACIÓN
        RemoteViews notificationView=new RemoteViews(this.getPackageName(),R.layout.notification);
        //Cada uno tendra una señal diferente y tendrá un receiver diferente.
        Intent buttonPlayIntent=null;
        Intent buttonForwardIntent=null;
        Intent buttonRewardIntent=null;
        Intent buttonStopIntent=null;
        //ASOCIO LOS "BOTONES" CON LOS RECEIVERS
        buttonPlayIntent=new Intent(this,RecieverPlay.class);
        PendingIntent pendingIntentPlay=PendingIntent.getBroadcast(this,0,buttonPlayIntent,0);
        //Asociamos los eventos de la notificacion personalizada.
        notificationView.setOnClickPendingIntent(R.id.boton_play,pendingIntentPlay);

        buttonForwardIntent=new Intent(this,RecieverForward.class);
        PendingIntent pendingIntentForward=PendingIntent.getBroadcast(this,0,buttonForwardIntent,0);
        //Asociamos los eventos de la notificacion personalizada.
        notificationView.setOnClickPendingIntent(R.id.boton_adelante,pendingIntentForward);

        buttonRewardIntent=new Intent(this,ReceiverReward.class);
        PendingIntent pendingIntentReward=PendingIntent.getBroadcast(this,0,buttonRewardIntent,0);
        //Asociamos los eventos de la notificacion personalizada.
        notificationView.setOnClickPendingIntent(R.id.boton_atras,pendingIntentReward);

        buttonStopIntent=new Intent(this,ReceiverStop.class);
        PendingIntent pendingIntentStop=PendingIntent.getBroadcast(this,0,buttonStopIntent,0);
        //Asociamos los eventos de la notificacion personalizada.
        notificationView.setOnClickPendingIntent(R.id.boton_cerrar,pendingIntentStop);

        //PREPARAR LA NOTIFICACIÓN
        PendingIntent pendingIntentActivity = obtenerPendingIntentActivity();
        Notification notification= new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("PLAYER title")
                .setContentText("PLAYER text")
                .setContent(notificationView)
                .setContentIntent(pendingIntentActivity)
                .build();
        NotificationManager notificationManager=(NotificationManager)getSystemService(Service.NOTIFICATION_SERVICE);
        notificationManager.notify(100,notification);

    }

    private PendingIntent obtenerPendingIntentActivity(){
        PendingIntent pendingIntent=null;

        Intent intentDestino=new Intent(this,ActividadDestino.class);
        //Para solo tener una única actividad cuando tengamos varias notificaciones
        intentDestino.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        pendingIntent=PendingIntent.getActivity(this,0,intentDestino,0);
        return pendingIntent;
    }



}
