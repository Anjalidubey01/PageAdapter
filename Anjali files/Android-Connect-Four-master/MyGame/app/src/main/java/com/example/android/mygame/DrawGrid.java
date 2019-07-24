package com.example.android.mygame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class DrawGrid {
    private float x1, y1, x2, y2;
    private char letter;
    Bitmap x,o;
    Bitmap xI,oI;
    int y3,y4,y5,y6;
    public DrawGrid(float x1, float y1, float x2, float y2, Bitmap x,Bitmap o,Bitmap xI,Bitmap oI){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.o = o;
        this.x = x;
        this.letter = ' ';
        this.xI = xI;
        this.oI = oI;

        y3 = (int)(y1-800);
        y4 =(int)(y2-800);
        y5 = y3;
        y6=y4;

    }
public void draw(Canvas canvas, Paint paint){
   // canvas.drawRect(x1,y1,x2,y2,null);
    canvas.drawLine(x1, y1, x2, y1, paint);
    canvas.drawLine(x2, y1, x2, y2, paint);
    canvas.drawLine(x1, y2, x2, y2, paint);
    canvas.drawLine(x1, y1, x1, y2, paint);
    if(letter!=' '){
    if(letter=='x'){
        if(y3<y1&&y4<y2){
            y3=y3+7;
            y4=y4+7;
        canvas.drawBitmap(xI,null,new Rect((int)x1,y3,(int)x2,y4),null);}
       if(y3>=y1&&y4>=y2){
        canvas.drawBitmap(x,null,new Rect((int)x1,(int)y1,(int)x2,(int)y2),null);
      }
    }
    if(letter=='o'){
        if(y3<y1&&y4<y2) {
            y3 = y3 + 7;
            y4 = y4 + 7;
            canvas.drawBitmap(oI, null, new Rect((int) x1, y3, (int) x2, y4), null);}
            if (y3 >= y1 && y4 >= y2) {
                canvas.drawBitmap(o, null, new Rect((int) x1, (int) y1, (int) x2, (int) y2), null);
            }

}}}
public void update() {
    if (y3> y1 && y4 > y2) {
        y3 = y3 - 5;
        y4 = y4- 5;
    }
    else if(y3==y1&&y4==y2){
      y3 = 900;
      y4 = 980;
     }
    else if(y3<y1&&y4<y2){
       y3 = 900;
       y4 = 980;
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

    public void setX1(float x1) {
        this.x1 = x1;
    }

    public float getY1() {
        return y1;
    }

    public void setY1(float y1) {
        this.y1 = y1;
    }

    public float getX2() {
        return x2;
    }

    public void setX2(float x2) {
        this.x2 = x2;
    }

    public float getY2() {
        return y2;
    }

    public void setY2(float y2) {
        this.y2 = y2;
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

    public Bitmap getO() {
        return o;
    }

    public Bitmap getX() {
        return x;
    }

}

