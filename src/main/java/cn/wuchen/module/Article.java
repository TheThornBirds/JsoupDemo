package cn.wuchen.module;

import java.util.Date;

public class Article {

    private String id;

    private String title;

    private String content;

    private Date date;

    private String type;


    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", type='" + type + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Article() {

    }

    public Article(String id, String title, String content, Date date, String type) {

        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.type = type;
    }
}
