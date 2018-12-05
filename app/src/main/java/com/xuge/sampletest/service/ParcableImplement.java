package com.xuge.sampletest.service;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcableImplement implements Parcelable{

    public int id;
    public String name;

    protected ParcableImplement(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    /**
     * 当前对象的内容描述，一般返回0即可
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * 将当前对象写入 序列化结构当中
     * @param dest - 要将当前对象写入的Parcel结构
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }

    /**
     * public static final一个都不能少，内部对象CREATOR的名称也不能改变，必须全部大写。
     * 重写接口中的两个方法：
     * createFromParcel(Parcel in) 实现从Parcel容器中读取传递数据值,封装成Parcelable对象返回逻辑层.
     * newArray(int size) 创建一个类型为T，长度为size的数组，供外部类反序列化本类数组使用。
     */
    public static final Creator<ParcableImplement> CREATOR = new Creator<ParcableImplement>() {
        /**
         * 从序列化后的对象中创建原始对象
         */
        @Override
        public ParcableImplement createFromParcel(Parcel in) {
            return new ParcableImplement(in);
        }

        /**
         * 创建指定长度的原始对象数组
         */
        @Override
        public ParcableImplement[] newArray(int size) {
            return new ParcableImplement[size];
        }
    };
}
