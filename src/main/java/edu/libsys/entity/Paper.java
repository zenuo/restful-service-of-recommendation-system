package edu.libsys.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Paper")
public class Paper {
    @JsonProperty("id")
    private int id;
    @JsonProperty("paperId")
    private String paperId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("searchWord")
    private String searchWord;
    @JsonProperty("source")
    private String source;
    @JsonProperty("url")
    private String url;
    @JsonProperty("intro")
    private String intro;
    @JsonProperty("likeCount")
    private int likeCount;
    @JsonProperty("disLikeCount")
    private int disLikeCount;
    @JsonProperty("field")
    private String field;
    @JsonProperty("indexTerm")
    private String indexTerm;
    @JsonProperty("author")
    private String author;

    public Paper() {
    }

    public Paper(int id, String paperId, String title, String searchWord, String source, String url, String intro, int likeCount, int disLikeCount, String field, String indexTerm, String author) {
        this.id = id;
        this.paperId = paperId;
        this.title = title;
        this.searchWord = searchWord;
        this.source = source;
        this.url = url;
        this.intro = intro;
        this.likeCount = likeCount;
        this.disLikeCount = disLikeCount;
        this.field = field;
        this.indexTerm = indexTerm;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
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

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getIndexTerm() {
        return indexTerm;
    }

    public void setIndexTerm(String indexTerm) {
        this.indexTerm = indexTerm;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", paperId='" + paperId + '\'' +
                ", title='" + title + '\'' +
                ", searchWord='" + searchWord + '\'' +
                ", source='" + source + '\'' +
                ", url='" + url + '\'' +
                ", intro='" + intro + '\'' +
                ", likeCount=" + likeCount +
                ", disLikeCount=" + disLikeCount +
                ", field='" + field + '\'' +
                ", indexTerm='" + indexTerm + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
