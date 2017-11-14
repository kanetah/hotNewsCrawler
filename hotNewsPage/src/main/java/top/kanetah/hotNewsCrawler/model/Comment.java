package top.kanetah.hotNewsCrawler.model;

import java.sql.Date;

/**
 * created by kane on 2017/11/6.
 */
public class Comment {

    private int id;
    private int userId;
    private int newsId;
    private String content;
    private Date time;

    public Comment() {
        super();
    }

    public Comment(int userId, int newsId, String content, Date date) {
        this.userId = userId;
        this.newsId = newsId;
        this.content = content;
        this.time = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
