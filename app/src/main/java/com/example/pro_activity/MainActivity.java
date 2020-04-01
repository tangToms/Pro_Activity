package com.example.pro_activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    private Context mContext;
    private NetStatusReceiver netStatusReceiver;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=MainActivity.this;
        setContentView(R.layout.l_main);
        //获取按钮
        Button button=findViewById(R.id.btn_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent，跳转新的Activity
                Intent intent=new Intent(mContext,NewActivity.class);
                //使用Intent传递数据,可以传递基本类型int,byte,char,string,short,long,double,float
                intent.putExtra("name","Main页面数据");
                //传递一个对象
                Person person=new Person(11,"tang");
                intent.putExtra("person",person);
                startActivity(intent);
            }
        });

        //隐式打开页面
        Button button1=findViewById(R.id.btn_2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent
                Intent intent=new Intent();
                intent.setAction("intent");
//                startActivity(intent);
                //需要获取打开Activity返回值，requestCode:多个Acitity返回值，分辨返回值的是哪个Activity
                startActivityForResult(intent,1);
            }
        });

        //隐式打开浏览器
        Button button2=findViewById(R.id.btn_3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent
                Intent intent=new Intent();
                intent.setAction("android.intent.action.VIEW");
                //打开浏览器，网页地址
                Uri uri=Uri.parse("http://www.baidu.com");
                //设置展示格式
                intent.setDataAndType(uri,"text/html");
                startActivity(intent);
            }
        });

        //生命周期Activity
        Button button3=findViewById(R.id.btn_4);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,LifeActivity.class);
                startActivity(intent);
            }
        });

//        //创建广播接收器
//        netStatusReceiver=new NetStatusReceiver();
//        //创建IntentFliter类对象
//        IntentFilter intentFilter=new IntentFilter();
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//        //注册广播
//        registerReceiver(netStatusReceiver,intentFilter);

//        //自定义发送广播
//        sendBroadcast(new Intent("android.net.conn.CONNECTIVITY_CHANGE"));

        //发送有序广播
        //设置Intent,
//        Intent intent=new Intent("intent");
        //设置发送的有序广播
        //receiverPermssion:接收广播权限；
        //resultReceiver：广播最终接收者，无论广播传播结束、或abortBroadcast，都接收到广播
        //initialCode:初始编码
        //initialData:广播名
        //initialExtras:广播携带数据
//        sendOrderedBroadcast(intent,
//                null,
//                null,
//                null,
//                1,
//                "",
//                null);

        //打开本地服务
        Button button4=findViewById(R.id.btn_5);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,MyServiceActivity.class);
                startActivity(intent);
            }
        });

        //打开远程服务
        Button button5=findViewById(R.id.btn_6);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,MyRemoteService.class);
                startService(intent);
            }
        });


    }

    //requestCode:多个Activity返回值时，判断哪个Activity的返回值；
    //resultCode:当其他页面有多个setResult,返回多种数据，判断是哪个result返回；
    //data:其他页面返回数据；
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //获取返回数据
        if (data!=null){
            String name = data.getStringExtra("name");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Activity销毁时，取消注册广播接收器
//        unregisterReceiver(netStatusReceiver);
    }
}
