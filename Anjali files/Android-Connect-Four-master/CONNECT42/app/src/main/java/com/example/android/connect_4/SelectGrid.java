package com.example.android.connect_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SelectGrid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_grid);
        TextView rows = (TextView)findViewById(R.id.textView2);
        TextView col =(TextView)findViewById(R.id.textView3);
    }
}
