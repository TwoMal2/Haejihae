package com.example.haejihae;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlarmSetFragment extends Fragment {

    ArrayList<SubscribeItems> myData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_alarm_set,container,false);


        myData = new ArrayList<>();
        addItem("Netflix","2022/02/08","31");
        addItem("Waave","2012/03/13","1");

        RecyclerView recyclerView = view.findViewById(R.id.rv_subscribe_items);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        SubscribeItemsRemoveAdapter adapter = new SubscribeItemsRemoveAdapter(myData);
        recyclerView.setAdapter(adapter);

        Button btn_remove_back = view.findViewById(R.id.btn_remove_back);
        btn_remove_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        Button btn_remove_remove = view.findViewById(R.id.btn_remove_remove);

        return view;
    }



    public void addItem(String name, String date, String dday){
        SubscribeItems item = new SubscribeItems();

        item.setName(name);
        item.setDate(date);
        item.setDday(dday);
        myData.add(item);
    }

}