package com.example.bitp6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private final List<Article> articlelist;
    private static OnItemClickListener listener;

    ///********
    public interface OnItemClickListener {void onItemClick (int position);}
    ///********
    LayoutInflater mInflater;
    public ArticleAdapter(List<Article> articlelist){
        this.articlelist = articlelist;
    }

///************
    public void setOnItemClickListener (OnItemClickListener listener){
        ArticleAdapter.listener = listener;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item_article_layout, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article article = articlelist.get(position);
        holder.txtTitle.setText(article.getTitle());
        holder.txtContent.setText(article.getContent());
        holder.txtViews.setText("lượt xem" + article.getViews());
        holder.imgCover.setImageResource(article.getImgcover());
    }

    @Override
    public int getItemCount() {
        return articlelist.size();
    }

    ///tạo ArticleViewHolder
    public static class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
       /* private final OnItemClickListener listener;*/
        public TextView txtTitle, txtContent, txtViews;
        public ImageView imgCover;
        /*private ArticleAdapter articleAdapter;*/
        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            /*this. articleAdapter = articleadapter;*/
            this.txtTitle = itemView.findViewById(R.id.txtTitle);
            this.txtContent = itemView.findViewById(R.id.txtContent);
            this.txtViews = itemView.findViewById(R.id.txtViews);
            this.imgCover = itemView.findViewById(R.id.imgCover);
           /* this.listener = listener;*/
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int position = getBindingAdapterPosition();
            if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onItemClick(position);
                }
        }
    }
}
