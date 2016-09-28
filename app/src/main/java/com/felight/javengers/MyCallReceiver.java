package com.felight.javengers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyCallReceiver extends BroadcastReceiver {
    public MyCallReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        Bundle data = intent.getExtras();
        if(data != null )
        {
            String state= data.getString(TelephonyManager.EXTRA_STATE);
            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING))
            {
                String phoneNumber = data.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Toast.makeText(context, phoneNumber, Toast.LENGTH_LONG).show();
            }
        }


    }
}
