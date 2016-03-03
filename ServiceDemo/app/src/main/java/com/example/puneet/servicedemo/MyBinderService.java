package com.example.puneet.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by puneet on 3/2/16.
 */
public class MyBinderService extends Service {
    private final IBinder myBinder = new LocalBinder();
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "Binder Service Created", Toast.LENGTH_LONG).show();
        return myBinder;
    }

    public class LocalBinder extends Binder{

        public MyBinderService getService(){
            return MyBinderService.this;
        }

    }


}
