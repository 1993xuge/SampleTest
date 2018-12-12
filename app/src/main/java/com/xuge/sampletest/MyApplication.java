package com.xuge.sampletest;

import android.app.Application;
import android.util.Log;

import com.xuge.sampletest.utils.Utils;

import java.util.concurrent.TimeUnit;

/**
 * Created at 2018/12/11 上午10:44.
 *
 * @author yixu.wang
 */
public class MyApplication extends Application{
    private static final String TAG = "xuge";
    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, this.hashCode() + "   onCreate: before " + Utils.formateDateWithDefault());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, this.hashCode() + "   onCreate: after " + Utils.formateDateWithDefault());
    }
}
