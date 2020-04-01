package com.example.pro_activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class WebActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l_web);
    }
}
