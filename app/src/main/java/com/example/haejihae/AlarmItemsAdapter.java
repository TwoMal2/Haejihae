package com.example.haejihae;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlarmItemsAdapter extends RecyclerView.Adapter<AlarmItemsAdapter.ViewHolder> {
    private ArrayList<String> myData;
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_service_name_details);

        }

    }

    AlarmItemsAdapter(ArrayList<String> myData, Context mContext) {
        this.myData = myData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.alarm_list, parent, false);
        AlarmItemsAdapter.ViewHolder viewHolder = new AlarmItemsAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = myData.get(position);

        holder.name.setText(item);
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

}
