package com.example.haejihae;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class CancelManualActivity extends AppCompatActivity {

    FragmentTransaction fragmentTransaction;
    ArrayList<Button> buttonArrayList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe_cancel_manual);
        Button btn = findViewById(R.id.btn_netflix);

        //프래그먼트 전환
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.layout_manual,new ManualNetflixFragment()).commit();
        findViewById(R.id.btn_netflix).setSelected(true);

        //뒤로 가기 버튼
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //버튼 배열 추가
        buttonArrayList.add(findViewById(R.id.btn_netflix));
        buttonArrayList.add(findViewById(R.id.btn_tving));
        buttonArrayList.add(findViewById(R.id.btn_wavve));
        buttonArrayList.add(findViewById(R.id.btn_watcha));
        buttonArrayList.add(findViewById(R.id.btn_disney));
        buttonArrayList.add(findViewById(R.id.btn_utube));
        buttonArrayList.add(findViewById(R.id.btn_melon));
        buttonArrayList.add(findViewById(R.id.btn_bugs));
        buttonArrayList.add(findViewById(R.id.btn_flo));
        

    }

    public void btnClick(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        for (Button b: buttonArrayList)
            b.setSelected(false);

        switch (view.getId()){
            case R.id.btn_netflix:
                findViewById(R.id.btn_netflix).setSelected(true);
                fragmentTransaction.replace(R.id.layout_manual, new ManualNetflixFragment()).commit();
                break;
            case R.id.btn_tving:
                findViewById(R.id.btn_tving).setSelected(true);
                fragmentTransaction.replace(R.id.layout_manual, new ManualTvingFragment()).commit();
                break;
            case R.id.btn_wavve:
                findViewById(R.id.btn_wavve).setSelected(true);
                fragmentTransaction.replace(R.id.layout_manual, new ManualWavveFragment()).commit();
                break;
            case R.id.btn_watcha:
                findViewById(R.id.btn_watcha).setSelected(true);
                fragmentTransaction.replace(R.id.layout_manual, new ManualWatchaFragment()).commit();
                break;
            case R.id.btn_disney:
                findViewById(R.id.btn_disney).setSelected(true);
                fragmentTransaction.replace(R.id.layout_manual, new ManualDisneyFragment()).commit();
                break;
            case R.id.btn_utube:
                findViewById(R.id.btn_utube).setSelected(true);
                fragmentTransaction.replace(R.id.layout_manual, new ManualYoutubeFragment()).commit();
                break;
            case R.id.btn_melon:
                findViewById(R.id.btn_melon).setSelected(true);
                fragmentTransaction.replace(R.id.layout_manual, new ManualMelonFragment()).commit();
                break;
            case R.id.btn_bugs:
                findViewById(R.id.btn_bugs).setSelected(true);
                fragmentTransaction.replace(R.id.layout_manual, new ManualBugsFragment()).commit();
                break;
            case R.id.btn_flo:
                findViewById(R.id.btn_flo).setSelected(true);
                fragmentTransaction.replace(R.id.layout_manual, new ManualFloFragment()).commit();
                break;

        }

    }


}
