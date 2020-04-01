package com.example.pro_activity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;

//远程Service类
public class MyRemoteService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("remoteService","start service");
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        Log.i("remoteService","destroy service");
        super.onDestroy();
    }

    private class MyBinder extends IMyAidlInterface.Stub{
        //重写Toas方法
        @Override
        public void showToast(){
            //调用service内部方法
            try {
                show();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    //内部show Toast方法
    private void show(){
        //远程Service，显示Toast，需要加上Looper.prepare()，Looper.loop()，不然报错
        Looper.prepare();
        Toast.makeText(this,"romote service:show toast",Toast.LENGTH_SHORT).show();
        Looper.loop();
    }
    //绑定时调用
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("remoteService","bind service");
        return new MyBinder();
    }
    //解除绑定调用
    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("remoteService","unbind service");
        return super.onUnbind(intent);
    }
}
