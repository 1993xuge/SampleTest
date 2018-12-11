package com.xuge.sampletest.retrofit;

import com.xuge.sampletest.retrofit.bean.BookResponse;
import com.xuge.sampletest.retrofit.bean.BookSearchResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface BlueService {

    // @GET注解就表示get请求
    // @Query表示请求参数，将会以key=value的方式拼接在url后面
    @GET("book/search")
    Call<BookSearchResponse> getSearchBooks(
            @Query("q") String name,
            @Query("tag") String tag,
            @Query("start") int start,
            @Query("count") int count
    );

    @GET("book/search")
    Call<BookSearchResponse> getSearchBooks(@QueryMap Map<String, String> options);

    @GET("book/{id}")
    Call<BookResponse> getBook(@Path("id") String id);

}
