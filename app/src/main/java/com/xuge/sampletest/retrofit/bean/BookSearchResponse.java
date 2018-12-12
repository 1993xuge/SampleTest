package com.xuge.sampletest.retrofit.bean;

import java.util.List;

public class BookSearchResponse {

    private int count;
    private int start;
    private int total;

    private List<BookResponse> books;

    public int getCount() {
        return count;
    }

    public int getStart() {
        return start;
    }

    public int getTotal() {
        return total;
    }

    public List<BookResponse> getBooks() {
        return books;
    }
}
