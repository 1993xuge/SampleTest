package com.xuge.sampletest.gson.bean.news;

import java.util.List;

public class HomeNewsPageBean {
    private String allNum;
    private String allPages;
    private String currentPage;
    private String maxResult;
    private List<HomeNewsContentList> contentlist;

    public String getAllNum() {
        return allNum;
    }

    public void setAllNum(String allNum) {
        this.allNum = allNum;
    }

    public String getAllPages() {
        return allPages;
    }

    public void setAllPages(String allPages) {
        this.allPages = allPages;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(String maxResult) {
        this.maxResult = maxResult;
    }

    public List<HomeNewsContentList> getContentlist() {
        return contentlist;
    }

    public void setContentlist(List<HomeNewsContentList> contentlist) {
        this.contentlist = contentlist;
    }
    /*@Override
    public String toString() {
        return "HomeNewsPageBean [allNum=" + allNum + ", allPages=" + allPages
                + ", currentPage=" + currentPage + ", maxResult=" + maxResult
                + ", contentlist=" + contentlist + "]";
    }*/
}
