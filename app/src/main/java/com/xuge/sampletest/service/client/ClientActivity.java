package com.xuge.sampletest.service.client;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.xuge.sampletest.IRemoteAidlInterface;
import com.xuge.sampletest.R;
import com.xuge.sampletest.bean.Person;
import com.xuge.sampletest.service.server.RemoteService;

import java.util.List;

public class ClientActivity extends Activity {
    private static final String TAG = ClientActivity.class.getSimpleName();

    private IRemoteAidlInterface remoteAidlInterface;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "ClientActivity  --> onServiceConnected");
            // 获取到IBinder，转换成AIDL
            remoteAidlInterface = IRemoteAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "ClientActivity  --> onServiceDisconnected");
            remoteAidlInterface = null;

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_client);
    }

    public void bindRemoteService(View view) {
        Log.d(TAG, "ClientActivity  --> bindRemoteService");
        Intent intent = new Intent(this, RemoteService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }

    public void unbindRemoteService(View view) {
        Log.d(TAG, "ClientActivity  --> unbindRemoteService");
        unbindService(serviceConnection);
    }

    private int index = 0;

    public void addPersonToRemote(View view) {
        if (remoteAidlInterface != null) {
            try {
                Person person = new Person("No." + index++);
                Log.d(TAG, "ClientActivity  --> unbindRemoteService; person = " + person);
                remoteAidlInterface.addPerson(person);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void getPersonListFromRemote(View view) {
        if (remoteAidlInterface != null) {
            try {
                List<Person> personList = remoteAidlInterface.getPersonList();
                Log.d(TAG, "ClientActivity  --> unbindRemoteService; size = " + personList.size());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

}
