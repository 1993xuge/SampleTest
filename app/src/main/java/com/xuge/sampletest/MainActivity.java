package com.xuge.sampletest;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xuge.sampletest.retrofit.TestRetrofitActivity;
import com.xuge.sampletest.bitmap.BitmapTestActivity;
import com.xuge.sampletest.service.ServiceTestActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CustomThread().start();
    }

    public void testService(View view) {
        startActivity(new Intent(this, ServiceTestActivity.class));
    }

    public void testRetrofit(View view) {
        startActivity(new Intent(this, TestRetrofitActivity.class));
    }

    private static class CustomThread extends Thread {
        @Override
        public void run() {
            super.run();

            Looper.prepare();
            Handler handler = new Handler();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Handler在CustomThread中发送的消息");
                }
            });
            Looper.loop();
        }
    }

    public void testBitmap(View view) {
        startActivity(new Intent(this, BitmapTestActivity.class));
    }
}
