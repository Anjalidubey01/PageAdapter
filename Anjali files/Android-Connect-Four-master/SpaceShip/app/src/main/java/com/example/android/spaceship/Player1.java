package com.example.android.spaceship;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Player1 {
    private Bitmap bitmap;
    private int x,y;
    private int speed = 0;
    private Boolean boosting;
    private final int gravity = -10;
    private int maxY;
    private int minY;
    private final int maxSpeed = 21;
    private final int minSpeed = 2;
    public Player1(Context context,int screenX,int screenY){
        x = 75;
        y = 50;
        speed = 1;
       bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.space);
       boosting = false;
       maxY = screenY-bitmap.getHeight();
       minY =0;
    }
    public void setBoosting(){
        boosting = true;
    }
    public void stopBoosting(){
        boosting = false;
    }
    public void update(){
        if(boosting){
            speed+=2;

        }
        else{
            speed-=5;
        }
        if(speed<minSpeed){
            speed = minSpeed;
        }
        y-=speed+gravity;
        if(y<minY){
            y =minY;
        }
        if(y>maxY){
            y = maxY;
        }
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
