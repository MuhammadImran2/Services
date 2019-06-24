package com.example.reintent;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log ;
import android.view.TextureView;

public class MyService extends Service {

    private  static final String TAG ="com.example.reintent";

    public MyService() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand method called");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                //this is for looop it run 5 time
                for (int i = 0; i<5; i++){
                    // futuretime store currenttime+5 second;
                    long futuretime = System.currentTimeMillis() + 5000 ;
                    //this is while loop currenttime less then futuretime
                    while (System.currentTimeMillis() < futuretime){

                        synchronized (this){
                            try {
                                //futuretime - systemtime(currenttime)

                                wait(futuretime - System.currentTimeMillis());

                                Log.i(TAG,"Service is ding something");

                            } catch (Exception e){

                            }
                        }
                    }

                }
            }
        };
        Thread buckyThread = new Thread(r);
        buckyThread.start();
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy method called");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        return null ;
    }
}
