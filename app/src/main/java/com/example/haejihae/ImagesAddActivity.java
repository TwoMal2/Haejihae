package com.example.haejihae;

import android.graphics.Color;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ImagesAddActivity extends AppCompatActivity {

    ArrayList<String> myData = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images_add);

        myData.add("넷플릭스");
        myData.add("웨이브");
        myData.add("티빙");
        myData.add("왓챠");
        myData.add("디즈니 플러스");
        myData.add("유튜브 프리미엄");
        myData.add("플로");
        myData.add("벅스");
        myData.add("멜론");
        myData.add("추가");

        RecyclerView recyclerView = findViewById(R.id.rv_service_list);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        ServiceItemsAdapter serviceItemsAdapter = new ServiceItemsAdapter(myData, this);
        recyclerView.setAdapter(serviceItemsAdapter);

    }
}
