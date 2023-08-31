//package com.example.blogsaga.utils.adapters;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.blogsaga.R;
//import com.example.blogsaga.utils.callbacks.RecyclerCallbacks;
//import com.example.blogsaga.utils.models.Articles;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class UpdateArticlesAdapter extends RecyclerView.Adapter<UpdateArticlesAdapter.ArticleHolder> {
//    private List<Articles> dataSet;
//    private RecyclerCallbacks listener;
//
//    public UpdateArticlesAdapter(List<Articles> dataset, Context context,RecyclerCallbacks callbacks) {
//        this.dataSet = dataset;
//        this.listener=callbacks;
//    }
//
//    @NonNull
//    @Override
//    public ArticleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View root = LayoutInflater.from(parent.getContext()).
//                inflate(R.layout.recycler_item_view, parent, false);
//        return new ArticleHolder(root, listener);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ArticleHolder holder, int position) {
//        int resource=dataSet.get(position).getArticle_image();
//        int resource2=dataSet.get(position).getAcc_image();
//        String textview=dataSet.get(position).getTitle();
//        String textview2=dataSet.get(position).getAcc_name();
//        String textview3=dataSet.get(position).getTime();
//        holder.setdata(resource,resource2,textview,textview2,textview3);
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return dataSet.size();
//    }
//
//    class ArticleHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        private final RecyclerCallbacks listener;
//
//        private ImageView artimg,accimg;
//        private TextView atitle,accname,time;
//
//        public ArticleHolder(@NonNull View itemView, RecyclerCallbacks listener) {
//            super(itemView);
//            artimg=itemView.findViewById(R.id.article_image);
//            accimg=itemView.findViewById(R.id.client_AC_image);
//            atitle=itemView.findViewById(R.id.article_title);
//            accname=itemView.findViewById(R.id.client_AC_id);
//            time=itemView.findViewById(R.id.times);
//            this.listener = listener;
//            itemView.setOnClickListener(this);
//        }
//
//        @Override
//        public void onClick(View view) {
//            listener.onClick(dataSet.get(getAdapterPosition()));
//        }
//
//        public void setdata(int resource, int resource2, String textview, String textview2, String textview3) {
//            artimg.setImageResource(resource);
//            accimg.setImageResource(resource2);
//            atitle.setText(textview);
//            accname.setText(textview2);
//            time.setText(textview3);
//        }
//    }
//}
