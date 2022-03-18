package com.example.haejihae;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;

public class LoadingActivity extends Activity {
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LoadingActivity.this, WelcomeActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        }, 3000);  //화면 전환에 소요되는 시간

    }




}
