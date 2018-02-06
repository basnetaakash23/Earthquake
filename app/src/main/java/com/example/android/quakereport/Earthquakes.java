package com.example.android.quakereport;

/**
 * Created by aakashbasnet on 1/23/18.
 */

public class Earthquakes {
    private double mMagnitude;

    private String mCity;

    private long mTimeinmilliseconds;

    private String mUrl;

    public Earthquakes(Double mMag, String mC, long mD, String link){
        mMagnitude = mMag;
        mCity = mC;
        mTimeinmilliseconds = mD;
        mUrl = link;
    }

    public int getMagnitude(){
        return (int)mMagnitude;
    }

    public String getCityName(){
        return mCity;
    }

    public long getmTimeinmilliseconds(){
        return mTimeinmilliseconds;
    }

    public String getUrl(){
        return mUrl;
    }
}
