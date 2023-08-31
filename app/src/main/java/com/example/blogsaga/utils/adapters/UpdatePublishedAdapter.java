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
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.blogsaga.R;
//import com.example.blogsaga.utils.callbacks.RecyclerPublishedCallbacks;
//import com.example.blogsaga.utils.models.Articles;
//
//import java.util.List;
//
//public class UpdatePublishedAdapter extends RecyclerView.Adapter<UpdatePublishedAdapter.PublishedHolder> {
//
//    private List<Articles> dataSet;
//
//    private RecyclerPublishedCallbacks callbacks;
//
//    public UpdatePublishedAdapter(List<Articles> dataSet, Context context, RecyclerPublishedCallbacks listner) {
//        this.dataSet = dataSet;
//        this.callbacks = listner;
//    }
//
//    @NonNull
//    @Override
//    public UpdatePublishedAdapter.PublishedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View root = LayoutInflater.from(parent.getContext()).
//                inflate(R.layout.bookmark_drafts_rv_item, parent, false);
//        return new PublishedHolder(root, callbacks);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull UpdatePublishedAdapter.PublishedHolder holder, int position) {
//        int resource=dataSet.get(position).getArticle_image();
//        int resource2=dataSet.get(position).getAcc_image();
//        String textview=dataSet.get(position).getTitle();
//        String textview2=dataSet.get(position).getAcc_name();
//        String textview3=dataSet.get(position).getTime();
//        holder.setdata(resource,resource2,textview,textview2,textview3);
//    }
//
//    @Override
//    public int getItemCount() {
//        return dataSet.size();
//    }
//
//    public class PublishedHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//
//        private RecyclerPublishedCallbacks callbacks;
//        private ImageView artimg,accimg;
//        private TextView atitle,accname,time;
//        public PublishedHolder(@NonNull View item, RecyclerPublishedCallbacks callbacks) {
//            super(item);
//            artimg=item.findViewById(R.id.article_image);
//            accimg=item.findViewById(R.id.client_AC_image);
//            atitle=item.findViewById(R.id.article_title);
//            accname=item.findViewById(R.id.client_AC_id);
//            time=item.findViewById(R.id.times);
//            this.callbacks=callbacks;
//            item.setOnClickListener(this);
//        }
//
//
//        @Override
//        public void onClick(View v) {
//            callbacks.onClick(dataSet.get(getAdapterPosition()));
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
