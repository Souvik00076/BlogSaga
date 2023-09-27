package com.example.blogsaga.utils.adapters;

import android.icu.text.CaseMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blogsaga.R;
import com.example.blogsaga.utils.models.Articles;

import java.util.ArrayList;

public class UpdateRecentAdapter extends RecyclerView.Adapter<UpdateRecentAdapter.RecentHolder> {

    private ArrayList<Articles> RecentSet;
    private int limit;

    public UpdateRecentAdapter(ArrayList<Articles> recentSet,int limit) {
        RecentSet = recentSet;
        this.limit=limit;
    }

    @NonNull
    @Override
    public UpdateRecentAdapter.RecentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_view,parent,false);
        return new RecentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UpdateRecentAdapter.RecentHolder holder, int position) {
        holder.bind(RecentSet.get(position));
    }

    @Override
    public int getItemCount() {
        return Math.min(RecentSet.size(),limit);
    }

    public void setData(Articles recentArticle) { RecentSet.add(recentArticle);
    }

    public class RecentHolder extends RecyclerView.ViewHolder {

        private TextView Tiltle;
        public RecentHolder(@NonNull View itemView) {
            super(itemView);
            Tiltle=itemView.findViewById(R.id.article_title);
        }

        public void bind(Articles articles) {
            Tiltle.setText(articles.getTitle());
        }
    }
}
