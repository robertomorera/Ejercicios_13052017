package com.example.cice.foregroundservice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

public class ForegroundService extends Service {

    private static MediaPlayer mediaPlayer;

    private static void play(){

        mediaPlayer.start();
    }

    private static void stop(){
        mediaPlayer.stop();
    }

    public ForegroundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
      return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer=MediaPlayer.create(this,R.raw.audio);

    }

    @Override
    public int onStartCommand(Intent intent,int flags,int startId) {

        Log.d("MENSAJE","SERVICIO INICIADO");

        String action=intent.getAction();

        if(action.equals("START")){
            //Quiero lanzar el servicio.

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


            startForeground(55,notification);
            ForegroundService.play();


        }else{

            //Quiero detener el servicio la acción sería igual a STOP.
            Toast.makeText(this,"PARANDO SERVICIO",Toast.LENGTH_LONG).show();
            stopForeground(true); //le quito el status de foreground service.
            stopSelf(); //detengo el servicio
            ForegroundService.stop(); //paramos la música.
        }

        return START_STICKY;
    }

    private PendingIntent obtenerPendingIntentActivity(){
        PendingIntent pendingIntent=null;

        Intent intentDestino=new Intent(this,MainActivity.class);
        //Para solo tener una única actividad cuando tengamos varias notificaciones
        intentDestino.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        pendingIntent=PendingIntent.getActivity(this,0,intentDestino,0);
        return pendingIntent;
    }


}
