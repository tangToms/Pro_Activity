package com.example.pro_activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class MyServiceActivity extends Activity {
    private Context mContext;
    private ServiceConnection serviceConnection;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l_service);
        mContext=MyServiceActivity.this;
        //获取Button组件
        Button btn_start=findViewById(R.id.btn_start);
        Button btn_close=findViewById(R.id.btn_close);
        Button btn_bind=findViewById(R.id.btn_bind);
        Button btn_unbind=findViewById(R.id.btn_unbind);
        //创建ServiceConnection类对象
        serviceConnection=new ServiceConnection() {
            //当Service的onBind方法返回一个特定类对象时调用，connected方法
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.i("service","Service connected");
                //onBind方法返回的MyBinder类对象
                IMyService myBinder= (IMyService) service;
                //调用方法，其实调用Service的myServiceShowToast方法
                myBinder.showToast();
            }
            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.i("service","Service disconnected");
            }
        };
        //创建服务
        final Intent intent=new Intent(mContext,MyService.class);
        //开启服务
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开启服务
                startService(intent);
            }
        });
        //关闭服务
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //停止服务
                stopService(intent);
            }
        });
        //绑定方式开启服务
        btn_bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //绑定服务方式开启服务
                bindService(intent,serviceConnection,Context.BIND_AUTO_CREATE);
            }
        });
        //解绑服务，断开服务
        btn_unbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(serviceConnection);
            }
        });
    }
}
