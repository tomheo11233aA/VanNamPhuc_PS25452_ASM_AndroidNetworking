package com.example.vannamphuc_ps25452_asm_androidnetworking.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.vannamphuc_ps25452_asm_androidnetworking.R;

public class NewsDetailFragment extends Fragment {
    private static final String ARG_NEWS_CONTENT = "news_content";
    public static NewsDetailFragment newInstance(String newsContent) {
        NewsDetailFragment fragment = new NewsDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NEWS_CONTENT, newsContent);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);
        TextView tvContent = view.findViewById(R.id.tv_news_content);
        if (getArguments() != null) {
            String newsContent = getArguments().getString(ARG_NEWS_CONTENT);
            tvContent.setText(newsContent);
        }
        return view;
    }
}
