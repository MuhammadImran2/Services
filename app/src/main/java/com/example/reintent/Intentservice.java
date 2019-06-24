package com.example.reintent;

import android.app.IntentService ;
import android.content.Intent ;
import android.util.Log ;

public class Intentservice extends IntentService{

    private static final String TAG = "com.example.reintent";

    public Intentservice(){
        super("Intent Service");

    }


    protected void onHandleIntent(Intent intent){
        // this is what the service does
        Log.i(TAG,"The Service has now started");
    }


}
