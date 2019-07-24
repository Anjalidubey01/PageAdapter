package com.example.android.tictactoe;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class gameBoard extends AppCompatActivity {

    SharedPreferences myPrefs;
    int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(new Grid(this));
        getSupportActionBar().hide();
        //myPrefs = getSharedPreferences("time", Activity.MODE_PRIVATE);


    }

}
