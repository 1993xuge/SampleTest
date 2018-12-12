package com.xuge.sampletest.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.xuge.sampletest.R;
import com.xuge.sampletest.retrofit.bean.BookResponse;
import com.xuge.sampletest.retrofit.bean.BookSearchResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 参考： https://www.jianshu.com/p/331f0bf161c2
 */
public class TestRetrofitActivity extends AppCompatActivity {

    private static final String TAG = TestRetrofitActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_retrofit);
    }

    public void testRetrofit(View view) {
        testRetrofit();
    }
    private void testRetrofit() {
        // baseUrl就是网络请求URL相对固定的地址，一般包括请求协议（如Http）、域名或IP地址、端口号等
        //addConverterFactory方法表示需要用什么转换器来解析返回值，GsonConverterFactory.create()表示调用Gson库来解析json返回值

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();


        BlueService blueService = retrofit.create(BlueService.class);

        // Call其实在Retrofit中就是行使网络请求并处理返回值的类，调用的时候会把需要拼接的参数传递进去
        // https://api.douban.com/v2/book/search?q=%E5%B0%8F%E7%8E%8B%E5%AD%90&tag=&start=0&count=3
        Call<BookSearchResponse> call = blueService.getSearchBooks("小王子", "", 0, 3);

        Map<String, String> options = new HashMap<>();
        options.put("q", "小王子");
        options.put("tag", null);
        options.put("start", "0");
        options.put("count", "3");
        Call<BookSearchResponse> call2 = blueService.getSearchBooks(options);

        // 使用Call实例完成同步或异步请求
        // testCallSync(call);

        testCallAsync(call);

    }

    private void getBook(){
        Retrofit retrofit = new Retrofit.Builder()
                .
    }

    private void testCallSync(final Call<BookSearchResponse> call) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BookSearchResponse bookSearchResponse = call.execute().body();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void testCallAsync(Call<BookSearchResponse> call) {
        call.enqueue(new Callback<BookSearchResponse>() {
            @Override
            public void onResponse(Call<BookSearchResponse> call, Response<BookSearchResponse> response) {
                BookSearchResponse  bookSearchResponse = response.body();
                Log.d(TAG, this.hashCode() + "   onResponse: count " + bookSearchResponse.getCount());
                Log.d(TAG, this.hashCode() + "   onResponse: start " + bookSearchResponse.getStart());
                Log.d(TAG, this.hashCode() + "   onResponse: total " + bookSearchResponse.getTotal());

                for(BookResponse bookResponse : bookSearchResponse.getBooks()){
                    Log.d(TAG, this.hashCode() + "   onResponse: title " + bookResponse.getTitle());
                }

            }

            @Override
            public void onFailure(Call<BookSearchResponse> call, Throwable t) {

            }
        });
    }

}
