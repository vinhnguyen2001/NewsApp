package com.springboot.entity;


import javax.persistence.*;

@Entity
@Table(name = "comment")
public class CommentEntity extends BaseEntity{


    private String content;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity userId;

    @ManyToOne
    @JoinColumn(name="news_id")
    private NewsEntity newsId;


    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public NewsEntity getNewsId() {
        return newsId;
    }

    public void setNewsId(NewsEntity newsId) {
        this.newsId = newsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
