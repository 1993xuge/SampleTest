package com.xuge.sampletest.retrofit.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

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

    private List<String> images;

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

    public List<String> getImages() {
        return images;
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

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void setOriginTitle(String originTitle) {
        this.originTitle = originTitle;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public void setTranslator(List<String> translator) {
        this.translator = translator;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setAltTitle(String altTitle) {
        this.altTitle = altTitle;
    }

    public void setAuthorIntro(String authorIntro) {
        this.authorIntro = authorIntro;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String price;

    public static class Rating {
        private int max;
        private long numRaters;
        private String average;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public long getNumRaters() {
            return numRaters;
        }

        public void setNumRaters(long numRaters) {
            this.numRaters = numRaters;
        }

        public String getAverage() {
            return average;
        }

        public void setAverage(String average) {
            this.average = average;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    private static class Tag {
        private long count;
        private String name;
        private String title;

        public long getCount() {
            return count;
        }

        public void setCount(long count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
