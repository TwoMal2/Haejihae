package com.example.haejihae;

import android.content.Context;
import android.content.Intent;
import android.graphics.BlendMode;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SubscribeItemsRemoveAdapter extends RecyclerView.Adapter<SubscribeItemsRemoveAdapter.ViewHolder> {
    private ArrayList<SubscribeItems> myData;
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_service_name, tv_date, tv_dday;
        float preX, dX;

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
                        CheckBox checkBox = itemView.findViewById(R.id.checkbox_remove);
                        preX = itemView.getX();
                        if(checkBox.isChecked()){
                            Animation animation = AnimationUtils.loadAnimation(mContext,R.anim.anim_right_to_left);
                            itemView.startAnimation(animation);
                            itemView.setX(itemView.getX() - dX);
                            checkBox.setChecked(false);
                        }
                        else{
                            Animation animation = AnimationUtils.loadAnimation(mContext,R.anim.anim_left_to_right);
                            itemView.startAnimation(animation);
                            itemView.setX(30);
                            dX = itemView.getX() - preX;
                            checkBox.setChecked(true);
                        }
                    }
                }
            });

        }
    }

    SubscribeItemsRemoveAdapter(ArrayList<SubscribeItems> myData, Context mContext){
        this.myData = myData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.subscribe_items_remove, parent, false);
        SubscribeItemsRemoveAdapter.ViewHolder viewHolder = new SubscribeItemsRemoveAdapter.ViewHolder(view);

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
