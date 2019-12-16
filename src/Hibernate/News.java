package Hibernate;

import java.util.Date;

public class News {
    private Integer id;
    private String title;
    private String author;
    private Date date;
    //必须要提供一个无参构造器用于反射
    private News(){
    }
    public News(String title, String author, Date date) {
        super();
        this.title = title;
        this.author = author;
        this.date = date;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                '}';
    }
}
