package com.waper.spider.model;

import java.io.Serializable;

/**
 * @ClassName Chapter
 * @Description TODO
 * @Author wangpeng
 * @Date 2020/3/3 17:52
 */
public class Chapter implements Serializable {
    private static final long serialVersionUID = 1L;
    /**id*/
    private int id;
    /**章节名称*/
    private String chapterName;
    /**小说链接*/
    private String url;
    /**小说名称*/
    private String bookName;
    /**下一张链接*/
    private String nextUrl;
    /**作者*/
    private String author;
    /**内容*/
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", chapterName='" + chapterName + '\'' +
                ", url='" + url + '\'' +
                ", bookName='" + bookName + '\'' +
                ", nextUrl='" + nextUrl + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
