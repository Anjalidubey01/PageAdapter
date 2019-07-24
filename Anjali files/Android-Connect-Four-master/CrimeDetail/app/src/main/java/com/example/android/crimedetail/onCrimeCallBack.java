package com.example.android.crimedetail;

import java.util.List;

public interface onCrimeCallBack {
    void onSuccess(List<Model> movies);

    void onError();
}
