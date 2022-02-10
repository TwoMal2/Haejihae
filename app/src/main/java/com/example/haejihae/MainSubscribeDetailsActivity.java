package com.example.haejihae;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainSubscribeDetailsActivity extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_subscribe_details);

        //달력 시간 설정
        Calendar calendar = Calendar.getInstance();
        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);


        //구독 정보 설정
        Intent intent = getIntent();

        final TextView name = findViewById(R.id.tv_service_name_details);
        final ImageView service = findViewById(R.id.iv_service);
        final Button date = findViewById(R.id.btn_subscribe_date);

        String service_name = intent.getStringExtra("Service name");
        if(service_name!=null){
            name.setText(service_name);
            switch (service_name){
                case "Netflix":
                    service.setImageResource(R.drawable.logo_netflix);
                    break;
                case "Wavve":
                    service.setImageResource(R.drawable.logo_wavve);
                    break;
                case "TVING":
                    service.setImageResource(R.drawable.logo_tving);
                    break;
                case "Watcha":
                case "Disney Plus":
                case "Youtube premium":
                case "FLO":
                case "Bugs":
                case "Melon":

            }
        }

        String service_date = intent.getStringExtra("Date");
        /*if(service_date!=null){
            if(Integer.parseInt(service_date)>=21&&Integer.parseInt(service_date)<26){
                date.setTextColor(Color.parseColor("#BA2676"));
            }else if(Integer.parseInt(service_date)>=14){
                date.setTextColor(Color.parseColor("#FC1D95"));
            }else if(Integer.parseInt(service_date)>=7){
                date.setTextColor(Color.parseColor("#ED00D5"));
            }else if(service_date=="0"){
                date.setText("Day");
                date.setTextColor(Color.parseColor("#EE2DFF"));
            }

            date.setText(service_date);
        }
*/

        //데베에 날짜 저장하는 코드 추가
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(MainSubscribeDetailsActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                                //calendar.set(Calendar.YEAR, year);
                                //calendar.set(Calendar.MONTH, month);
                                //calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                                date.setText(String.format("%d/%d/%d",year,month+1,dayOfMonth));
                            }
                        }, mYear, mMonth, mDay).show();

            }

        });

        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }


}
