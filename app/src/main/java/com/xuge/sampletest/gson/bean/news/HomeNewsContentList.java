package com.xuge.sampletest.gson.bean.news;

import java.util.List;

public class HomeNewsContentList {
    private String channelId;
    private String channelName;
    private String desc;
    private List<HomeNewsImages> imageurls;
    private String link;
    private String pubDate;
    private String source;
    private String title;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<HomeNewsImages> getImageurls() {
        return imageurls;
    }

    public void setImageurls(List<HomeNewsImages> imageurls) {
        this.imageurls = imageurls;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /*@Override
    public String toString() {
        return "HomeNewsContentList [channelId=" + channelId + ", channelName="
                + channelName + ", desc=" + desc + ", imageurls=" + imageurls
                + ", link=" + link + ", pubDate=" + pubDate + ", source="
                + source + ", title=" + title + "]";
    }*/
}
