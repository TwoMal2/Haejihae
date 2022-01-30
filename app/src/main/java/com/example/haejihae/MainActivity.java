package com.example.haejihae;

import static androidx.navigation.ui.NavigationUI.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ArrayList<SubscribeItems> myData;

    ImageButton itemAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        /*
        myData = new ArrayList<>();
        addItem("Netflix","2022/02/08","31");
        addItem("Waave","2012/03/13","1");

        RecyclerView recyclerView = findViewById(R.id.rv_subscribe_items);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        SubscribeItemsAdapter adapter = new SubscribeItemsAdapter(myData);
        recyclerView.setAdapter(adapter);*/


        /*drawerLayout = findViewById(R.id.drawer_layout);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        //로그인 로그아웃 둘 중 하나는 숨기기
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_logout).setVisible(false);


        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_subscribeInfo);
        */

        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);

        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);

        findViewById(R.id.btn_notifications).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),alarmSet.class);
                startActivity(intent);
            }

        });

    }


    public void itemAddClick(View v){
        Intent intent = new Intent(this, Items_addActivity.class);
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.nav_subscribeInfo:
                break;
            case R.id.nav_alarmSet:
                Intent intent = new Intent(MainActivity.this, alarmSet.class);
                startActivity(intent);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void addItem(String name, String date, String dday){
        SubscribeItems item = new SubscribeItems();

        item.setName(name);
        item.setDate(date);
        item.setDday(dday);
        myData.add(item);
    }

}