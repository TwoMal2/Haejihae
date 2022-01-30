package com.example.haejihae;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainSubscribeDetailsActivity extends AppCompatActivity {

    Toolbar toolbar;
    ArrayList<SubscribeItems> myData;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_subscribe_details);

/*
        myData = new ArrayList<>();
        addItem("Netflix","2022/02/08","D-31");
        addItem("Waave","2012/03/13","D-1");

        RecyclerView recyclerView = findViewById(R.id.rv_subscribe_remove_items);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        SubscribeItemsRemoveAdapter adapter = new SubscribeItemsRemoveAdapter(myData);
        recyclerView.setAdapter(adapter);*/

        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }


    public void addItem(String name, String date, String dday){
        SubscribeItems item = new SubscribeItems();

        item.setName(name);
        item.setDate(date);
        item.setDday(dday);
        myData.add(item);
    }


}
