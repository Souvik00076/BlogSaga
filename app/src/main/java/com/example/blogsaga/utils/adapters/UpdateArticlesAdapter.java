package com.example.blogsaga.utils.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blogsaga.R;
import com.example.blogsaga.utils.models.Articles;

import java.util.ArrayList;

public class UpdateArticlesAdapter extends RecyclerView.Adapter<UpdateArticlesAdapter.ArticleHolder> {

    private ArrayList<Articles> dataSet;

    public UpdateArticlesAdapter(ArrayList<Articles> dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public ArticleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_view, parent, false);
        return new ArticleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setData(Articles articles) {
        dataSet.add(articles);
    }

    class ArticleHolder extends RecyclerView.ViewHolder {
        public ArticleHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}