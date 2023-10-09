package com.example.blogsaga.utils.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blogsaga.R;
import com.example.blogsaga.utils.callbacks.RecyclerCallbacks;
import com.example.blogsaga.utils.models.Articles;
import com.example.blogsaga.utils.models.UserTokens;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

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
        holder.bind(dataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void setData(Articles articles) {
        dataSet.add(articles);
    }


    class ArticleHolder extends RecyclerView.ViewHolder {
        private TextView aTitle,account_name;
        private ShapeableImageView article_image,accoun_img;

        public ArticleHolder(@NonNull View itemView) {
            super(itemView);
            aTitle = itemView.findViewById(R.id.article_title);
            article_image = itemView.findViewById(R.id.article_image);
            account_name=itemView.findViewById(R.id.client_AC_id);
            accoun_img=itemView.findViewById(R.id.client_AC_image);
        }


        public void bind(final Articles articles) {
            aTitle.setText(articles.getTitle());
            String path = "Users/" + UserTokens.getInstance().
                    getAuth().getCurrentUser().
                    getEmail().
                    replace(".", "") +
                    "/articles/images/" + articles.getImageUri() + "/";
            StorageReference storageReference = UserTokens.getInstance().getImageReference().child(path);
            storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    System.out.println(uri);
                    Picasso.get()
                            .load(uri)
                            .placeholder(R.drawable.back_app) // Placeholder image while loading
                            .error(R.drawable.back_app) // Error image if download fails
                            .into(article_image);
                }
            });

        }

    }
}