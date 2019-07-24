package com.example.android.spaceship;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameLook extends SurfaceView implements Runnable {
    volatile Boolean playing;
    private Thread gameThread=null;
    private Player1 player1;
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;

    public GameLook(Context context,int screenX,int screenY) {
        super(context);
        player1 = new Player1(context,screenX,screenY);
        paint = new Paint();
        surfaceHolder = getHolder();

    }
    public void run(){
        while (playing){
            update();
            drawBoard();
            control();
        }
    }

    private void update() {
        player1.update();
    }
    private void drawBoard(){
        if(surfaceHolder.getSurface().isValid()){
            canvas = surfaceHolder.lockCanvas();
            canvas.drawColor(Color.BLACK);
            canvas.drawBitmap(player1.getBitmap(),player1.getX(),player1.getY(),paint);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }

    }
    private void control(){
        try{
            gameThread.sleep(17);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void pause(){
        playing = false;
        try{
            gameThread.join();
        } catch (InterruptedException e) {
        }
    }
    public void resume(){
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_UP:
                player1.setBoosting();
                break;
             case  MotionEvent.ACTION_DOWN:
                 player1.stopBoosting();
                 break;
        }

        return true;
    }
}
