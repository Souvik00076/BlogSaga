package com.example.blogsaga.utils.adapters;

import android.icu.text.CaseMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blogsaga.R;
import com.example.blogsaga.utils.models.Articles;
import com.example.blogsaga.utils.models.UserTokens;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        private ImageView bookmark;
        public RecentHolder(@NonNull View itemView) {
            super(itemView);
            Tiltle=itemView.findViewById(R.id.article_title);
            bookmark=itemView.findViewById(R.id.bookmark_recent);
        }

        public void bind(Articles articles) {
            Tiltle.setText(articles.getTitle());
            bookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UserTokens tokens=UserTokens.getInstance();
                    FirebaseAuth auth=tokens.getAuth();
                    String email= auth.getCurrentUser().getEmail().replace(".","");
                    DatabaseReference reference= tokens.getDatabaseReference();
                    String uniquekey=articles.getId();
                    reference.child("Users/"+email+"/bookmarks/").push().setValue(uniquekey).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(itemView.getContext(), "Article save to Bookmark", Toast.LENGTH_SHORT).show();
                            bookmark.setImageResource(R.drawable.baseline_bookmark_24);
                        }
                    });
                }
            });
        }
    }
}
