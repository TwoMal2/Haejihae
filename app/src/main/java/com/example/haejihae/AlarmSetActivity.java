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
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;
import java.util.Calendar;

public class AlarmSetActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    TimePicker picker;
    Button btnGet;
    TextView tvw;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_set);
        findViewById(R.id.reAlarms).setVisibility(View.INVISIBLE);

        tvw=(TextView)findViewById(R.id.textView1);
        picker=(TimePicker)findViewById(R.id.timePicker1);
        picker.setIs24HourView(true);
        btnGet=(Button)findViewById(R.id.button1);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour, minute;
                String am_pm;
                if (Build.VERSION.SDK_INT >= 23 ){
                    hour = picker.getHour();
                    minute = picker.getMinute();
                }
                else{
                    hour = picker.getCurrentHour();
                    minute = picker.getCurrentMinute();
                }
                if(hour > 12) {
                    am_pm = "PM";
                    hour = hour - 12;
                }
                else
                {
                    am_pm="AM";
                }
                tvw.setText( hour +":"+ minute+" "+am_pm);
            }
        });

        // 알림설정 : n일전 설정 스피너
        Spinner date_spinner = findViewById(R.id.date_spinner);
        ArrayAdapter<CharSequence> d_adapter = ArrayAdapter.createFromResource(this, R.array.day, R.layout.alarmset_day_spinner);
        d_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        date_spinner.setAdapter(d_adapter);
        date_spinner.setOnItemSelectedListener(this);



        // 알림설정 : 다시알림 횟수 설정 스피너
        Spinner re_t_spinner = findViewById(R.id.re_time_spinner);
        ArrayAdapter<CharSequence> re_t_adapter = ArrayAdapter.createFromResource(this, R.array.re_t, R.layout.alarmset_day_spinner);
        re_t_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        re_t_spinner.setAdapter(re_t_adapter);
        re_t_spinner.setOnItemSelectedListener(this);

        // 알림설정 : 다시알림 시간 설정 스피너
        Spinner re_t2_spinner = findViewById(R.id.re_time2_spinner);
        ArrayAdapter<CharSequence> re_t2_adapter = ArrayAdapter.createFromResource(this, R.array.re_t2, R.layout.alarmset_day_spinner);
        re_t2_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        re_t2_spinner.setAdapter(re_t2_adapter);
        re_t2_spinner.setOnItemSelectedListener(this);

        ToggleButton reAlarm = findViewById(R.id.alarm_re);

        //구독 정보 설정
        Intent intent = getIntent();

        final TextView name = findViewById(R.id.Name);
        final TextView date = findViewById(R.id.npday);
        final TextView d_day = findViewById(R.id.DDay);

        String service_name = intent.getStringExtra("Service name");
        if(service_name!=null)name.setText(service_name);

        String service_date = intent.getStringExtra("Date");
        if(service_date!=null)date.setText(service_date);

        String service_dday = intent.getStringExtra("DDay");
        if(service_dday!=null)d_day.setText(service_dday);

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

        findViewById(R.id.btnClose).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //아직 값 저장하는건 완성 못했어요
                //finish();
                Intent intent = new Intent();
                intent.putExtra("EXIT",true);
                setResult(RESULT_OK, intent);

                finish();
            }
        });



    }
    @Override

    protected void onPause() {
        super.onPause();
        overridePendingTransition(0,0);
    }


    @Override
    public void onItemSelected(AdapterView<?> AdapterView, View view, int position, long l) {
        String text = AdapterView.getItemAtPosition(position).toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
