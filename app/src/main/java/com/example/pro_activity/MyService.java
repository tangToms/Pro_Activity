package com.example.pro_activity;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

//创建Service
public class MyService extends Service{
    //创建服务调用
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("service","create Service");
    }
    //已经弃用
//    @Override
//    public void onStart(Intent intent, int startId) {
//        super.onStart(intent, startId);
//    }
    //开启服务调用
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("service","start Service");
        return super.onStartCommand(intent, flags, startId);
    }
    //绑定方式开启服务
    private class MyBinder extends Binder implements IMyService{
        //通过MyBinder提供Service中方法
        @Override
        public void showToast(){
            myServiceShowToast();
        }
    }
    private void myServiceShowToast(){
        Toast.makeText(this,"service show toast",Toast.LENGTH_SHORT).show();
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }
    //解除绑定方法
    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("service","unbind service");
        return super.onUnbind(intent);
    }
    //销毁时调用
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("service","destroy Service");
    }
}
