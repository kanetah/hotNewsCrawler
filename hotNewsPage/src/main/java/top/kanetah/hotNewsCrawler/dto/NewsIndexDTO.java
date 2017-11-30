package top.kanetah.hotNewsCrawler.dto;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsIndexDTO {

    private int id;
    private String src;
    private String title;
    private Date date;
    private String type;
    private int rank;
    private String imgSrc;

    public NewsIndexDTO(int id, String src, String title, Date date, String type, int rank, String content) {
        this.id = id;
        this.src = src;
        this.title = title;
        this.date = date;
        this.type = type;
        this.rank = rank;
        setImgSrcByContent(content);
    }

    private void setImgSrcByContent(String content) {
        Pattern pattern = Pattern.compile("(?<=(<img(.{0,10000})src=[\",\']))(.+?)(?=([\",\'](.+?)>))");
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            this.imgSrc = matcher.group();
            if (
                    this.imgSrc.equals("http://img1.cache.netease.com/cnews/css13/img/end_news.png") ||
                    this.imgSrc.equals("http://mat1.gtimg.com/ent/groupCSS/ajax-loadernone.gif")
                    )
                this.imgSrc = null;
        } else
            this.imgSrc = null;
    }

    public NewsIndexDTO(int id, String src, String title, Date date, String type, int rank) {
        this.id = id;
        this.src = src;
        this.title = title;
        this.date = date;
        this.type = type;
        this.rank = rank;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
