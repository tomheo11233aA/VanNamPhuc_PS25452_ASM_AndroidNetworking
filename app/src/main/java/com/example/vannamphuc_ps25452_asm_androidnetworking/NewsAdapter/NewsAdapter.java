package com.example.vannamphuc_ps25452_asm_androidnetworking.NewsAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vannamphuc_ps25452_asm_androidnetworking.HomeActivity;
import com.example.vannamphuc_ps25452_asm_androidnetworking.R;
import com.example.vannamphuc_ps25452_asm_androidnetworking.model.News;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{
    private List<News> newsList;
    private Context context;
    private HomeActivity.OnItemClickListener listener;

    public NewsAdapter(List<News> newsList, Context context, HomeActivity.OnItemClickListener listener) {
        this.newsList = newsList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_news,parent,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News newsItem = newsList.get(position);
        holder.tvTitle.setText(newsItem.getTitle());
        holder.tvAuthor.setText(newsItem.getAuthor());
        holder.tvCreatedAt.setText(newsItem.getCreatedAt());
        holder.itemView.setOnClickListener(v -> {
            // Use the listener's method when an item is clicked
            listener.onItemClick(newsItem);
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle,tvAuthor,tvCreatedAt;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle=itemView.findViewById(R.id.tv_title);
            tvAuthor=itemView.findViewById(R.id.tv_author);
            tvCreatedAt=itemView.findViewById(R.id.tv_time);
        }
    }
}
