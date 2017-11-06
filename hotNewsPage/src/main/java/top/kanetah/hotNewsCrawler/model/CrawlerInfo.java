package top.kanetah.hotNewsCrawler.model;

import java.sql.Date;

/**
 * created by kane on 2017/11/6.
 */
public class CrawlerInfo {

    private int id;
    private Date startDate;
    private Date finalDate;
    private int count;
    private String state;
    private String message;

    public CrawlerInfo() {
        super();
    }

    public CrawlerInfo(String state, String message) {
        this.state = state;
        this.message = message;

        this.startDate = new Date(new java.util.Date().getTime());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
