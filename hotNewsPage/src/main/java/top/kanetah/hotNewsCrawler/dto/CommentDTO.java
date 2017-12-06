package top.kanetah.hotNewsCrawler.dto;

public class CommentDTO {
    private int id;
    private String userName;
    private String newsTitle;
    private String content;
    private String time;

    public CommentDTO(int id, String userName, String newsTitle, String content, String time) {
        this.id = id;
        this.userName = userName;
        this.newsTitle = newsTitle;
        this.content = content;
        this.time = time;
    }

    public CommentDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
