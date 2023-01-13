package com.example.AplicatieCM;

import static java.lang.Thread.sleep;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "MyService";


    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.


        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: Service STARTED");
//        Toast.makeText(getApplicationContext(), "Service STARTED by User", Toast.LENGTH_SHORT).show();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        ToneGenerator beep = new ToneGenerator(AudioManager.STREAM_MUSIC, 300);
        beep.startTone(ToneGenerator.TONE_CDMA_ANSWER, 300);

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: Services DESTROVED");
//        Toast.makeText(getApplicationContext(), "Service STOPPED by User", Toast.LENGTH_SHORT).show();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Log.i(TAG, "onTaskRemoved: Stopping Service by Swipe");
        //stopSelf();
        super.onTaskRemoved(rootIntent);

    }

}