package com.example.haejihae;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainSubscribeDetailsActivity extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_subscribe_details);

        Intent intent = getIntent();

        TextView name = findViewById(R.id.tv_service_name_details);
        ImageView service = findViewById(R.id.iv_service);
        TextView date = findViewById(R.id.btn_subscribe_date);

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
        if(service_date!=null){
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


        findViewById(R.id.btn_subscribe_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent();
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
