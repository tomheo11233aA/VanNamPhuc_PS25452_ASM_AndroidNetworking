package com.example.vannamphuc_ps25452_asm_androidnetworking.model;

public class News {
    private String createdAt;
    private String author;
    private String title;
    private String content;
    private String id;

    public News(String createdAt, String author, String title, String content, String id) {
        this.createdAt = createdAt;
        this.author = author;
        this.title = title;
        this.content = content;
        this.id = id;
    }

    public News() {

    }

    public static News fromJson(org.json.JSONObject jsonObject) {
        News news = new News();
        try {
            news.setAuthor(jsonObject.getString("author"));
            news.setContent(jsonObject.getString("content"));
            news.setCreatedAt(jsonObject.getString("createdAt"));
            news.setId(jsonObject.getString("id"));
            news.setTitle(jsonObject.getString("title"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return news;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
