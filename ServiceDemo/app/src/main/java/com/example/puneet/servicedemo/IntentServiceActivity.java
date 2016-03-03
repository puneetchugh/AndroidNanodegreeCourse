package com.example.puneet.servicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by puneet on 3/1/16.
 */
public class IntentServiceActivity extends IntentService {


    public IntentServiceActivity(){

        super("My Intent Service");

    }
    @Override
    public void onCreate(){

        super.onCreate();
        Toast.makeText(this, "Service Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.d("Intent Service", "Displaying a message");
    }
}
