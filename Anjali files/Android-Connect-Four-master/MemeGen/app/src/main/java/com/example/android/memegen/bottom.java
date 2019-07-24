package com.example.android.memegen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class bottom extends Fragment {
    private static TextView top;
    private static TextView bottom;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.bottom_frag,container,false);
        top = (TextView)view1.findViewById(R.id.textView);
        bottom = (TextView)view1.findViewById(R.id.textView2);

        return view1;
    }
    public void setMeme(String topa,String bott){
        top.setText(topa);
        bottom.setText(bott);
    }
}
