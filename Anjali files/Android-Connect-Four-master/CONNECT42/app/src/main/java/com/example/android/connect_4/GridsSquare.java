package com.example.android.connect_4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

class GridsSquare {
    private float x1, y1, x2, y2;
    int y3,y4;
    private char letter;
    //Drawable xom,oom;
    Bitmap oom,xom;
    public GridsSquare(float x1, float y1, float x2, float y2, Bitmap xDrawable, Bitmap oDrawable){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.oom = oDrawable;
        this.xom = xDrawable;
        this.letter = ' ';
        y3 = 345;
        y4 = 425;
    }

    public void draw(Canvas canvas, Paint paint) {
        canvas.drawLine(x1, y1, x2, y1, paint);
        canvas.drawLine(x2, y1, x2, y2, paint);
        canvas.drawLine(x1, y2, x2, y2, paint);
        canvas.drawLine(x1, y1, x1, y2, paint);
    }
    public void update(){
        if(y3>y1&&y4>y2){
     y3--;
     y4--;}
        else{
            y3 = (int)y1;
            y4 = (int)y2;
        }
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public float getX1() {
        return x1;
    }

    public float getX2() {
        return x2;
    }

    public void setX2(float x2) {
        this.x2 = x2;
    }

    public void setX1(float x1) {
        this.x1 = x1;
    }

    public float getY1() {
        return y1;
    }

    public void setY1(float y1) {
        this.y1 = y1;
    }

    public float getY2() {
        return y2;
    }

    public void setY2(float y2) {
        this.y2 = y2;
    }

    public Bitmap getOom() {
        return oom;
    }

    public void setOom(Bitmap oom) {
        this.oom = oom;
    }

    public Bitmap getXom() {
        return xom;
    }

    public void setXom(Bitmap xom) {
        this.xom = xom;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    public int getY4() {
        return y4;
    }

    public void setY4(int y4) {
        this.y4 = y4;
    }
}
