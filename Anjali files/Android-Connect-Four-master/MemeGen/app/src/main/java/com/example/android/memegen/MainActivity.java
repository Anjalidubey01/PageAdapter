package com.example.android.memegen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;

public class MainActivity extends AppCompatActivity implements top.TopSectionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void createMeme(String top, String bot) {
        bottom bota = (bottom)getSupportFragmentManager().findFragmentById(R.id.fragment);
        bota.setMeme(top,bot);
    }
}
