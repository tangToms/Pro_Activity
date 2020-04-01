package com.example.pro_activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

//Activity的生命周期
public class LifeActivity extends Activity {
    //创建Activiy时调用
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l_life);
        Log.i("life","create");
    }
    //页面展示时调用
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("life","start");
    }
    //页面不可见调用
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("life","stop");
    }
    //页面可见，但无法获取焦点
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("life","pause");
    }
    //页面恢复时调用，页面可见可获取焦点
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("life","resume");
    }
    //销毁Activity调用
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("life", "destroy");
    }
}
