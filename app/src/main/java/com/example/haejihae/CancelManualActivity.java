package com.example.haejihae;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class CancelManualActivity extends AppCompatActivity {

    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe_cancel_manual);

        //프래그먼트 전환
        fragmentTransaction.replace(R.id.layout_manual,new ManualNetflixFragment()).commit();

        //뒤로 가기 버튼
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        

    }

    public void btnClick(View view) {
        switch (view.getId()){
            case R.id.btn_netflix:
                fragmentTransaction.replace(R.id.layout_manual, new ManualNetflixFragment()).commit();
                break;
            case R.id.btn_tving:
                fragmentTransaction.replace(R.id.layout_manual, new ManualTvingFragment()).commit();
                break;
            case R.id.btn_wavve:
                fragmentTransaction.replace(R.id.layout_manual, new ManualWavveFragment()).commit();
                break;
            case R.id.btn_watcha:
                fragmentTransaction.replace(R.id.layout_manual, new ManualWatchaFragment()).commit();
                break;
            case R.id.btn_disney:
                fragmentTransaction.replace(R.id.layout_manual, new ManualDisneyFragment()).commit();
                break;
            case R.id.btn_utube:
                fragmentTransaction.replace(R.id.layout_manual, new ManualYoutubeFragment()).commit();
                break;
            case R.id.btn_melon:
                fragmentTransaction.replace(R.id.layout_manual, new ManualMelonFragment()).commit();
                break;
            case R.id.btn_bugs:
                fragmentTransaction.replace(R.id.layout_manual, new ManualBugsFragment()).commit();
                break;
            case R.id.btn_flo:
                fragmentTransaction.replace(R.id.layout_manual, new ManualFloFragment()).commit();
                break;

        }

    }


}
