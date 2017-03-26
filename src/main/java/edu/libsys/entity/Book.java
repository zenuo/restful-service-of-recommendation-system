package edu.libsys.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Book")
public class Book {
    @JsonProperty("id")
    private int id;
    @JsonProperty("marcRecId")
    private int marcRecId;
    @JsonProperty("callId")
    private String callId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("author")
    private String author;
    @JsonProperty("publisher")
    private String publisher;
    @JsonProperty("pubYear")
    private String pubYear;
    @JsonProperty("isbn")
    private String isbn;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("likeCount")
    private int likeCount;
    @JsonProperty("disLikeCount")
    private int disLikeCount;

    public Book() {
    }

    public Book(int id, int marcRecId, String callId, String title, String author, String publisher, String pubYear, String isbn, String imageUrl, int likeCount, int disLikeCount) {
        this.id = id;
        this.marcRecId = marcRecId;
        this.callId = callId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pubYear = pubYear;
        this.isbn = isbn;
        this.imageUrl = imageUrl;
        this.likeCount = likeCount;
        this.disLikeCount = disLikeCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarcRecId() {
        return marcRecId;
    }

    public void setMarcRecId(int marcRecId) {
        this.marcRecId = marcRecId;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPubYear() {
        return pubYear;
    }

    public void setPubYear(String pubYear) {
        this.pubYear = pubYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getDisLikeCount() {
        return disLikeCount;
    }

    public void setDisLikeCount(int disLikeCount) {
        this.disLikeCount = disLikeCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", marcRecId=" + marcRecId +
                ", callId='" + callId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", pubYear='" + pubYear + '\'' +
                ", isbn='" + isbn + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", likeCount=" + likeCount +
                ", disLikeCount=" + disLikeCount +
                '}';
    }
}
