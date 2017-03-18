package edu.libsys.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
    private int marcRecId;
    private String callId;
    private String title;
    private String author;
    private String publisher;
    private String pubYear;
    private String isbn;
    private int likeCount;
    private int disLikeCount;

    public Book() {
    }

    @XmlAttribute(name = "marcRecId")
    public int getMarcRecId() {
        return marcRecId;
    }

    public void setMarcRecId(int marcRecId) {
        this.marcRecId = marcRecId;
    }

    @XmlAttribute(name = "callId")
    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    @XmlAttribute(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlAttribute(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlAttribute(name = "publisher")
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @XmlAttribute(name = "pubYear")
    public String getPubYear() {
        return pubYear;
    }

    public void setPubYear(String pubYear) {
        this.pubYear = pubYear;
    }

    @XmlAttribute(name = "isbn")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @XmlAttribute(name = "likeCount")
    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    @XmlAttribute(name = "disLikeCount")
    public int getDisLikeCount() {
        return disLikeCount;
    }

    public void setDisLikeCount(int disLikeCount) {
        this.disLikeCount = disLikeCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "marcRecId=" + marcRecId +
                ", callId='" + callId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", pubYear='" + pubYear + '\'' +
                ", isbn='" + isbn + '\'' +
                ", likeCount=" + likeCount +
                ", disLikeCount=" + disLikeCount +
                '}';
    }
}
