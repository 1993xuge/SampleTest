package com.xuge.sampletest.retrofit.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.concurrent.Executors;

public class BookResponse {

    private Rating rating;
    private String subtitle;
    private List<String> author;
    private String pubdate;
    private List<Tag> tags;

    @SerializedName("origin_title")
    private String originTitle;

    private String image;

    private String binding;

    private List<String> translator;

    private String catalog;

    private String pages;

    private Images images;

    private String alt;

    private String id;

    private String publisher;

    private String isbn10;

    private String isbn13;

    private String title;

    private String url;

    @SerializedName("alt_title")
    private String altTitle;

    @SerializedName("author_intro")
    private String authorIntro;

    private String summary;

    private String price;


    public Rating getRating() {
        return rating;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public List<String> getAuthor() {
        return author;
    }

    public String getPubdate() {
        return pubdate;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public String getOriginTitle() {
        return originTitle;
    }

    public String getImage() {
        return image;
    }

    public String getBinding() {
        return binding;
    }

    public List<String> getTranslator() {
        return translator;
    }

    public String getCatalog() {
        return catalog;
    }

    public String getPages() {
        return pages;
    }


    public String getAlt() {
        return alt;
    }

    public String getId() {
        return id;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getAltTitle() {
        return altTitle;
    }

    public String getAuthorIntro() {
        return authorIntro;
    }

    public String getSummary() {
        return summary;
    }

    public String getPrice() {
        return price;
    }

    public Images getImages() {
        return images;
    }
}
