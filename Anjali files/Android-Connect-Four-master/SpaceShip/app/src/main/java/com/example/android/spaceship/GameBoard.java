package com.example.android.spaceship;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

public class GameBoard extends AppCompatActivity {
   private GameLook Screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Screen = new GameLook(this,size.x,size.y);
        setContentView(Screen);
        getSupportActionBar().hide();

    }
    @Override
    protected void onPause(){
        super.onPause();
        Screen.pause();
    }
    @Override
    protected void onResume(){
        super.onResume();
        Screen.resume();
    }
}
