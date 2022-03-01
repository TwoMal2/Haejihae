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

public class AlarmSetAdapter extends RecyclerView.Adapter<AlarmSetAdapter.ViewHolder> {
    private ArrayList<SubscribeItems> myData;
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_service_name, tv_date, tv_dday;

        ViewHolder(View itemView) {
            super(itemView);

            tv_service_name=itemView.findViewById(R.id.tv_service_name);
            tv_date=itemView.findViewById(R.id.tv_date);
            tv_dday=itemView.findViewById(R.id.tv_dday);

            itemView.setClickable(true);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(position!=RecyclerView.NO_POSITION){
                        Intent intent = new Intent(mContext, AlarmSetActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);

                        intent.putExtra("Service name",tv_service_name.getText().toString());
                        intent.putExtra("Date", tv_date.getText().toString());
                        intent.putExtra("DDay", tv_dday.getText().toString());

                        mContext.startActivity(intent);
                    }
                }
            });
        }
    }

    AlarmSetAdapter(ArrayList<SubscribeItems> myData, Context mContext){
        this.myData = myData;
        this.mContext = mContext;
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
