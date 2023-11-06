package com.example.vannamphuc_ps25452_asm_androidnetworking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.vannamphuc_ps25452_asm_androidnetworking.NewsAdapter.NewsAdapter;
import com.example.vannamphuc_ps25452_asm_androidnetworking.databinding.ActivityHomeBinding;
import com.example.vannamphuc_ps25452_asm_androidnetworking.fragment.NewsDetailFragment;
import com.example.vannamphuc_ps25452_asm_androidnetworking.model.News;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private NewsAdapter newsAdapter;
    private List<News> newsList = new ArrayList<>();
    private static final String NEWS_API_URL = "https://6544e01e5a0b4b04436d20c7.mockapi.io/news/news";
    private boolean isLoading = false;
    private int currentPage = 1;
    private int pageSize = 10;
    public interface OnItemClickListener {
        void onItemClick(News newsItem);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        newsAdapter = new NewsAdapter(newsList, this, newsItem -> {
            NewsDetailFragment detailFragment = NewsDetailFragment.newInstance(newsItem.getContent());
            binding.fragmentContainer.setVisibility(View.VISIBLE);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, detailFragment)
                    .addToBackStack(null) // Thêm giao dịch này vào ngăn xếp lùi để người dùng có thể quay lại
                    .commit();
            if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                // Khi không còn Fragment nào trong ngăn xếp, ẩn FrameLayout
                binding.fragmentContainer.setVisibility(View.GONE);
            }
        });

        binding.rvNews.setAdapter(newsAdapter);

        getNews();

        binding.rvNews.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
                if (!isLoading && (visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0) {
                    getNews();
                }
            }
        });

    }

    private void setLoading(boolean isLoading) {
        binding.viewDimBackground.setVisibility(isLoading ? View.VISIBLE : View.GONE);
        binding.progressBar.setVisibility(isLoading ? View.VISIBLE : View.GONE);
        this.isLoading = isLoading;
    }

    private void getNews() {
        if (this.isLoading) {
            return;
        }
        setLoading(true);
        String url = NEWS_API_URL + "?page=" + currentPage + "&limit=" + pageSize;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject jsonObject = response.getJSONObject(i);
                            News news = News.fromJson(jsonObject);
                            newsList.add(news);
                        }
                        newsAdapter.notifyDataSetChanged();
                        currentPage++;
                    } catch (Exception e) {
                        showToast("Error: " + e.getMessage());
                    } finally {
                        setLoading(false);
                        binding.progressBar.setVisibility(View.GONE);
                    }
                },
                error -> {
                    showToast("Error: " + error.getMessage());
                    setLoading(false);
                    binding.progressBar.setVisibility(View.GONE);
                }
        );
        binding.progressBar.setVisibility(View.VISIBLE);
        VolleySingleton.getInstance(this).addToRequestQueue(jsonArrayRequest);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}