package com.example.pro_activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

//广播接收
public class PowerReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //接收到广播执行逻辑
        Log.i("receiver","power low");
        //终止广播
        abortBroadcast();
    }
}
