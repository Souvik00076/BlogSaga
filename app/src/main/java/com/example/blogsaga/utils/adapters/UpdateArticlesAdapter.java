package com.example.blogsaga.utils.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blogsaga.R;
import com.example.blogsaga.utils.callbacks.RecyclerCallbacks;
import com.example.blogsaga.utils.models.Articles;

import java.util.ArrayList;

public class UpdateArticlesAdapter extends RecyclerView.Adapter<UpdateArticlesAdapter.ArticleHolder> {
    private final ArrayList<Articles> dataSet;
    private final RecyclerCallbacks listener;

    public UpdateArticlesAdapter(Fragment context) {
        dataSet = new ArrayList<>();
        listener = (RecyclerCallbacks) context;
    }

    @NonNull
    @Override
    public ArticleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recycler_item_view, parent, false);
        return new ArticleHolder(root, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    class ArticleHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final RecyclerCallbacks listener;

        public ArticleHolder(@NonNull View itemView, RecyclerCallbacks listener) {
            super(itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(dataSet.get(getAdapterPosition()));
        }
    }
}
