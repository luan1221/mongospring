package com.luan1221.mongospring.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document
public class Post implements Serializable {

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private User author;

    public Post() {}

    public Post(String id, Date date, String title, String body, User author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public User getAuthor() {
        return author;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
