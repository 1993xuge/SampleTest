package com.xuge.sampletest.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.xuge.sampletest.R;

public class ServiceTestActivity extends AppCompatActivity {
    private static final String TAG = "xuge";

    /**
     * ServiceConnection的匿名类：用来接收 连接Service和断开Service连接的回调
     */
    private ServiceConnection serviceConnection = new ServiceConnection() {

        /**
         * 在Activity与Service解除关联的时候调用
         * @param name -
         * @param service -
         */
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "ServiceConnection --> onServiceConnected : name " + name.getClassName());

            if (service instanceof CustomService.CustomBinder) {
                ((CustomService.CustomBinder) service).serviceConnectActivity();
            }
        }

        /**
         * 在Activity与Service建立关联和解除关联的时候调用
         * @param name -
         */
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "ServiceConnection --> onServiceDisconnected : name " + name.getClassName());
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_service);
    }

    public void startService(View view) {
        Log.d(TAG, "Click -->  startService");
        startService(new Intent(this, CustomService.class));
    }

    public void stopService(View view) {
        Log.d(TAG, "Click -->  stopService");
        stopService(new Intent(this, CustomService.class));
    }

    public void bindService(View view) {
        Log.d(TAG, "Click -->  bindService");

        Intent bindIntent = new Intent(this, CustomService.class);
        bindService(bindIntent, serviceConnection, BIND_AUTO_CREATE);
        //参数说明
        //第一个参数:Intent对象
        //第二个参数:上面创建的Serviceconnection实例
        //第三个参数:标志位
        //这里传入BIND_AUTO_CREATE表示在Activity和Service建立关联后自动创建Service
        //这会使得MyService中的onCreate()方法得到执行，但onStartCommand()方法不会执行
    }

    public void unbindService(View view) {
        Log.d(TAG, "Click -->  unbindService");
        unbindService(serviceConnection);
    }
}
