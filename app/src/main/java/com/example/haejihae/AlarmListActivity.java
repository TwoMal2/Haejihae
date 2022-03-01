package com.example.haejihae;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlarmListActivity extends AppCompatActivity {

    private ArrayList<String> myData = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_list);

        for(int i=0;i<10;i++)
            myData.add("Netflix");

        RecyclerView recyclerView = findViewById(R.id.rv_alarm_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
        AlarmItemsAdapter alarmItemsAdapter = new AlarmItemsAdapter(myData, this);
        recyclerView.setAdapter(alarmItemsAdapter);



        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
