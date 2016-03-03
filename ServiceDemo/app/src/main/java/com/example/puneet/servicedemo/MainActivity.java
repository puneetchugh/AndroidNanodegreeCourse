package com.example.puneet.servicedemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    private MyBinderService binderService;
    private boolean status;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBinderService.LocalBinder binder = (MyBinderService.LocalBinder) service;
            binder.getService();
            status = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "We have started with Service Demo", Toast.LENGTH_LONG);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void SimpleService(View view){

        Intent intent = new Intent(this, SimpleService.class);
        intent.putExtra("message", "This message is from Main Activity");
        startService(intent);

    }

    public void IntentService(View view){
        Intent intent = new Intent(this, IntentServiceActivity.class);
        startService(intent);

    }

    public void BindService(View view){
        Intent intent = new Intent(this, MyBinderService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
        status = true;
        Toast.makeText(this, "Service binded", Toast.LENGTH_LONG).show();
    }

    public void UnBindService(View view){

        if(status){

            unbindService(serviceConnection);
            Toast.makeText(this, "Service unbind successful", Toast.LENGTH_SHORT).show();
            status = false;
        }else{
            Toast.makeText(this, "Service Unbinded", Toast.LENGTH_SHORT).show();
        }
    }

    public void youTubeAccess(View view){
        Intent intent = new Intent(this, MyYouTubePlayer.class);
        startActivity(intent);
    }
}
