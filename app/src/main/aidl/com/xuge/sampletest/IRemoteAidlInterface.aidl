// IRemoteAidlInterface.aidl
package com.xuge.sampletest;
import com.xuge.sampletest.bean.Person;

// Declare any non-default types here with import statements

interface IRemoteAidlInterface {
    void addPerson(in Person person);

    List<Person> getPersonList();
}
