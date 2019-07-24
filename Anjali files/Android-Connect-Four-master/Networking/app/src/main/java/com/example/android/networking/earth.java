package com.example.android.networking;

public class earth {
private String mag;
private String place;
private long date;
public earth(String mag,String place,long date) {
    this.mag = mag;
    this.date = date;
    this.place = place;
}

    public long getDate() {
        return date;
    }

    public String getMag() {
        return mag;
    }

    public String getPlace() {
        return place;
    }
}
