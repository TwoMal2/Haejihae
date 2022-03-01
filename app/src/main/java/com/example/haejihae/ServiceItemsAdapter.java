package com.example.haejihae;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ServiceItemsAdapter extends RecyclerView.Adapter<ServiceItemsAdapter.ViewHolder> {
    private ArrayList<String> myData;
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView image;

        ViewHolder(View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.tv_service_item);
            itemView.setClickable(true);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(position!=RecyclerView.NO_POSITION){
                        Intent intent = new Intent(mContext, Items_addActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                        intent.putExtra("ServiceItem", name.getText().toString());
                        //intent.putExtra("ServiceImage",image);

                        mContext.startActivity(intent);
                        ((Activity) mContext).finish();

                    }
                }
            });

        }

    }

    ServiceItemsAdapter(ArrayList<String> myData, Context mContext){
        this.myData = myData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.service_list, parent, false);
        ServiceItemsAdapter.ViewHolder viewHolder = new ServiceItemsAdapter.ViewHolder(view);

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
