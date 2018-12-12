package com.xuge.sampletest.retrofit.bean;

/**
 * Created at 2018/12/12 上午9:45.
 *
 * @author yixu.wang
 */
public class Rating {
    private int max;
    private long numRaters;
    private String average;
    private int min;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public long getNumRaters() {
        return numRaters;
    }

    public void setNumRaters(long numRaters) {
        this.numRaters = numRaters;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
