package com.example.blogsaga.utils.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blogsaga.R;
import com.example.blogsaga.utils.callbacks.NotificationCallbacks;
import com.example.blogsaga.utils.models.NotificationModel;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationHolder> {

    private ArrayList<NotificationModel> notificationSet;
NotificationCallbacks listner;
    public NotificationAdapter(ArrayList<NotificationModel> notificationSet ,Context contetx, NotificationCallbacks listner){
        this.notificationSet=notificationSet;
        this.listner=listner;
    }

    @NonNull
    @Override
    public NotificationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new NotificationHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.NotificationHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return notificationSet.size();
    }

    public void setNotificationSet(ArrayList<NotificationModel> notificationSet){
        this.notificationSet=notificationSet;
        this.notifyDataSetChanged();
    }
    public class NotificationHolder extends RecyclerView.ViewHolder {

        NotificationCallbacks callbacks;

        public NotificationHolder(@NonNull View view) {
            super(view);
        }
    }
}
