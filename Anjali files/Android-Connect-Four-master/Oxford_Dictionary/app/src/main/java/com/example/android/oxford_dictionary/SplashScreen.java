package com.example.android.oxford_dictionary;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        ImageView ox = (ImageView)findViewById(R.id.imageView);
        TranslateAnimation animation = new TranslateAnimation(0.0f, 0.0f,-10.0f,600.0f);
        animation.setDuration(3000);
        animation.setRepeatCount(0);
        animation.setRepeatMode(1);
        animation.setFillAfter(true);
        ox.startAnimation(animation);
        logo jk = new logo();
        jk.start();
    }
    private class logo extends Thread{
        public void run(){
            try{

                sleep(4000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Intent i = new Intent(SplashScreen.this,MainActivity.class);
            startActivity(i);
            SplashScreen.this.finish();
        }

    }
}
