package com.example.android.tictactoe;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public class GridLines {
    private float x1, y1, x2, y2;
    private char letter;
    Drawable xom,oom;
    public GridLines(float x1, float y1, float x2, float y2, Drawable xDrawable,Drawable oDrawable) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.oom = oDrawable;
        this.xom = xDrawable;
        this.letter = ' ';
    }
    public void draw(Canvas canvas, Paint paint){
        canvas.drawLine(x2,y1,x2, y2,paint);
        canvas.drawLine(x1,y1,x1,y2,paint);
        canvas.drawLine(x1,y1,x2,y1,paint);
        canvas.drawLine(x1,y2,x2, y2,paint);



        if(letter != ' '){
            if(letter == 'x'){
                xom.setBounds((int)x1,(int)y1,(int)x2,(int)y2);
                xom.draw(canvas);}
        }
        if(letter == 'o'){
            oom.setBounds((int) x1, (int)y1, (int) x2, (int) y2);
            oom.draw(canvas);}

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

    public void setLetter(char c){
        this.letter = c;
    }

    public char getLetter() {
        return letter;
    }
}



