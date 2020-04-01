package com.example.pro_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class NewActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l_new);
        //获取上页面传递数据
        Intent intent=getIntent();
        String name = intent.getStringExtra("name");
        //intent.getIntExtra()
        //获取传过来对象
        Person p= (Person) intent.getSerializableExtra("person");

        //返回MainActivity,返回数据
        Button button=findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent,保存返回数据
                Intent intent=new Intent();
                intent.putExtra("name","haha");
                //返回数据
                setResult(0,intent);
                //结束页面，返回
                finish();
            }
        });
    }
}
