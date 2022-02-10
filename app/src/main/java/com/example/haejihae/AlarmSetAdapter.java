package com.example.haejihae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlarmSetAdapter extends RecyclerView.Adapter<AlarmSetAdapter.ViewHolder> {
    private ArrayList<SubscribeItems> myData;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_service_name, tv_date, tv_dday;

        ViewHolder(View itemView) {
            super(itemView);

            tv_service_name=itemView.findViewById(R.id.tv_service_name);
            tv_date=itemView.findViewById(R.id.tv_date);
            tv_dday=itemView.findViewById(R.id.tv_dday);
        }
    }

    AlarmSetAdapter(ArrayList<SubscribeItems> myData){
        this.myData = myData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.activity_alarm_set_detail, parent, false);
        AlarmSetAdapter.ViewHolder viewHolder = new AlarmSetAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SubscribeItems item = myData.get(position);

        holder.tv_service_name.setText(item.getName());
        holder.tv_date.setText(item.getDate());
        holder.tv_dday.setText(item.getDday());
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }



}
