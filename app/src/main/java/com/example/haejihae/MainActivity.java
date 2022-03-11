package com.example.haejihae;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    //Toolbar toolbar;
    ArrayList<SubscribeItems> myData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        //로그인 로그아웃 둘 중 하나는 숨기기
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_logout).setVisible(false);


        navigationView.bringToFront();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_subscribeInfo);

        //아이템 추가 , 데이터베이스 연동 예정
        myData = new ArrayList<>();
        addItem("Netflix","2022/02/08","31");
        addItem("Wavve","2012/03/13","1");

        RecyclerView recyclerView = findViewById(R.id.rv_subscribe_items);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        SubscribeItemsAdapter adapter = new SubscribeItemsAdapter(myData, this);
        recyclerView.setAdapter(adapter);


        findViewById(R.id.iv_menu).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        findViewById(R.id.iv_notifications).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), AlarmListActivity.class);
                startActivity(intent);
            }

        });

        // + - 버튼 클릭
        ImageButton btn_add = findViewById(R.id.btn_add);

        ImageButton btn_remove = findViewById(R.id.btn_remove);

        ImageButton btn_alarmSet = findViewById(R.id.btn_alarmSet);

        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SubscribeItemsRemoveAdapter adapter = new SubscribeItemsRemoveAdapter(myData, getApplicationContext());
                recyclerView.setAdapter(adapter);

                findViewById(R.id.btn_remove_remove).setVisibility(View.VISIBLE);
                findViewById(R.id.btn_remove_back).setVisibility(View.VISIBLE);

                /*
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                SubscribeInfoRemoveFragment subscribeInfoRemoveFragment = new SubscribeInfoRemoveFragment();
                transaction.replace(R.id.layout_subscribe, subscribeInfoRemoveFragment);
                transaction.commit();*/
            }
        });

        btn_alarmSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlarmSetAdapter adapter = new AlarmSetAdapter(myData,getApplicationContext());
                recyclerView.setAdapter(adapter);

                findViewById(R.id.btn_alarmSet).setVisibility(View.VISIBLE);
                findViewById(R.id.btn_remove_back).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.btn_remove_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SubscribeItemsAdapter adapter = new SubscribeItemsAdapter(myData, getApplicationContext());
                recyclerView.setAdapter(adapter);

                findViewById(R.id.btn_remove_remove).setVisibility(View.INVISIBLE);
                findViewById(R.id.btn_remove_back).setVisibility(View.INVISIBLE);
            }
        });

    }

    public void itemAddClick(View v){
        Intent intent = new Intent(this, ImagesAddActivity.class);
        intent.putExtra("data","Test Popup");
        startActivityForResult(intent, 1);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    public void addItem(String name, String date, String dday) {
        SubscribeItems item = new SubscribeItems();

        item.setName(name);
        item.setDate(date);
        item.setDday(dday);
        myData.add(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.nav_subscribeInfo:
                break;
            case R.id.nav_alarmSet:
                Intent intent = new Intent(MainActivity.this, AlarmSetActivity.class);
                startActivity(intent);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }





}