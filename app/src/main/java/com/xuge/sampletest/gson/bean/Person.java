package com.xuge.sampletest.gson.bean;

import com.google.gson.annotations.SerializedName;

public class Person {

    @SerializedName(value = "personName", alternate = {"pm", "pName"})
    private String name;

    @SerializedName(value = "personAge")
    private int age;

    private boolean sex;

    public Person(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isSex() {
        return sex;
    }

    /*
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }*/

}
