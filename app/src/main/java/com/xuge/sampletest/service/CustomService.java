package com.xuge.sampletest.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class CustomService extends Service {
    private static final String TAG = CustomService.class.getSimpleName();

    private CustomBinder customBinder = new CustomBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "CustomService -->  onBind");
        return customBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "CustomService -->  onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "CustomService -->  onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "CustomService -->  onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "CustomService -->  onDestroy");
    }

    class CustomBinder extends Binder {
        public void serviceConnectActivity() {
            Log.d(TAG, "CustomBinder --> serviceConnectActivity");
        }
    }
}
