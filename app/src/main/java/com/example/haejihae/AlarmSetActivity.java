package com.example.haejihae;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class AlarmSetActivity extends AppCompatActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_set);
        findViewById(R.id.reAlarms).setVisibility(View.INVISIBLE);

        ToggleButton reAlarm = findViewById(R.id.alarm_re);

        //구독 정보 설정
        Intent intent = getIntent();

        final TextView name = findViewById(R.id.Name);
        final TextView date = findViewById(R.id.sday);
        final TextView DDay = findViewById(R.id.DDay);

        String service_name = intent.getStringExtra("Service name");
        if(service_name!=null)name.setText(service_name);

        String service_date = intent.getStringExtra("Date");
        if(service_date!=null)date.setText(service_date);

        String service_DDay = intent.getStringExtra("DDay");
        if(service_DDay!=null)DDay.setText(service_DDay);

        reAlarm.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener(){
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked){
                        if(isChecked){
                            findViewById(R.id.reAlarms).setVisibility(View.VISIBLE);
                        }else{
                            findViewById(R.id.reAlarms).setVisibility(View.INVISIBLE);
                        }
                    }
                }
        );

        findViewById(R.id.x_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
    @Override

    protected void onPause() {
        super.onPause();
        overridePendingTransition(0,0);
    }

}
