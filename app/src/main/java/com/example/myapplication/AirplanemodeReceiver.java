package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AirplanemodeReceiver extends BroadcastReceiver {


    public static final String TAG = "My TAG";

    @Override
    public void onReceive(Context context, Intent intent) {

        boolean state = intent.getBooleanExtra("state", false);
        Log.e(TAG,""+state);
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        CharSequence text = "Hello toast";
        int duration = Toast.LENGTH_LONG;


        if(!state) {
            text="Airplane mode OFF";
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            text = "Airplane mode ON";
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }


    }


}