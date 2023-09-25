package com.example.blogsaga.utils.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blogsaga.R;
import com.example.blogsaga.utils.callbacks.RecyclerCallbacks;
import com.example.blogsaga.utils.models.Articles;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;

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
     Articles articles=dataSet.get(position);
     holder.aTitle.setText(articles.getTitle());
     holder.article_image.setImageBitmap(holder.byteArrayToBitmap(articles.getImageBytes()));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void setData(Articles articles) {
        dataSet.add(articles);
    }


    class ArticleHolder extends RecyclerView.ViewHolder {
        private TextView aTitle;
        private ShapeableImageView article_image;
        public ArticleHolder(@NonNull View itemView) {
            super(itemView);
            aTitle=itemView.findViewById(R.id.article_title);
            article_image=itemView.findViewById(R.id.article_image);
        }

        public  Bitmap byteArrayToBitmap(byte[] byteArray) {
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        }

    }
}