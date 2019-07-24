package com.example.android.mygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        logo jk = new logo();
        jk.start();
    }
    private class logo extends Thread{
        public void run(){
            try{
                sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Intent i = new Intent(SplashScreen.this,Select.class);
            startActivity(i);
            SplashScreen.this.finish();
        }
    }
}
