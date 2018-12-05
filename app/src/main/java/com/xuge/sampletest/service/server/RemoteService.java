package com.xuge.sampletest.service.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v4.os.IResultReceiver;
import android.util.Log;

import com.xuge.sampletest.IRemoteAidlInterface;
import com.xuge.sampletest.bean.Person;

import java.util.ArrayList;
import java.util.List;

public class RemoteService extends Service {

    private static final String TAG = RemoteService.class.getSimpleName();

    private List<Person> personList;

    /**
     * 客户端与服务端绑定的回调，返回iBinder后，客户端就可以通过它远程调用服务端的方法，实现即时通讯
     *
     * @param intent
     * @return
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "RemoteService  --> onBind");
        personList = new ArrayList<>();
        return iBinder;
    }

    /**
     * 创建Binder对象，实现AIDL指定的方法
     */
    private IBinder iBinder = new IRemoteAidlInterface.Stub() {
        @Override
        public void addPerson(Person person) throws RemoteException {
            Log.d(TAG, "RemoteService  --> addPerson; person = " + person);
            personList.add(person);
        }

        @Override
        public List<Person> getPersonList() throws RemoteException {
            Log.d(TAG, "RemoteService  --> getPersonList; size = " + personList.size());
            return personList;
        }
    };
}
