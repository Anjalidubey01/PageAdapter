package com.example.android.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.example.android.tictactoe.GridLines;
import com.example.android.tictactoe.R;
import com.example.android.tictactoe.Winner;

import java.util.Random;

public class Medium extends View implements View.OnTouchListener {
    private Paint paint,anit,red,yellow;
    private int screenWidth,screenHeight;
    private int increment;
    private int xMargin;
    private int yMargin = 50;
    private char turn;
    private Drawable cross;
    private Drawable zero;
    public GridLines[][] spots;
    private Context context;
    private Random re = new Random();

    public Medium(Context context) {
        super(context);
        cross = getResources().getDrawable(R.drawable.cro);
        zero = getResources().getDrawable(R.drawable.ze);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        anit = new Paint();
        anit.setColor(Color.BLUE);
        anit.setTextSize(30);
        red = new Paint();
        red.setColor(Color.RED);
        yellow = new Paint();
        yellow.setColor(Color.YELLOW);
        this.context = context;
        increment  = screenWidth / (5);
        xMargin = increment;
        spots = new GridLines[3][3];
        this.setOnTouchListener(this);

        turn = 'x';

        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++) {
                GridLines curCell = new GridLines(xMargin + increment * col, yMargin + increment * row, xMargin + increment * (col + 1), yMargin + increment * (row + 1), cross, zero);

                spots[row][col] = curCell;
            }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        super.onDraw(canvas);
        canvas.drawColor(Color.CYAN);
        for (int row = 0; row < 3; row++)
            for (int col = 0; col <3; col++)
                spots[row][col].draw(canvas, paint);

    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() != MotionEvent.ACTION_DOWN)
            return false;

        int x = (int) event.getX();
        int y = (int) event.getY();
        Log.d("keyboard", "x pos: " + x);
        Log.d("keyboard", "y pos: " + y);

        for(int gX = 0; gX < spots.length; gX++){
            for(int gY = 0; gY < spots[gX].length; gY++){
                GridLines gridCell = spots[gX][gY];
                if(x > gridCell.getX1() && x < gridCell.getX2())
                    if(y > gridCell.getY1() && y < gridCell.getY2()) {
                        if(turn == 'x'){
                            dropInColumn(turn,gX, gY);}
                        if (checkForLineOfThree() ) {
                            finishGame(turn);
                        }
                        if(turn == 'x'){
                            turn = 'o';
                            int q=0;
                            for(int i = 0;i<3;i++)
                                for(int j = 0;j<3;j++)
                                    if(spots[i][j].getLetter() != ' ')
                                        q++;
                            if(q<9)
                                computerPlay();
                        }

                        postInvalidate();
                        return true;
                    }
            }
        }
        return false;
    }

    private void computerPlay() {
        int poX=0;
        int poY=0;
        if(!checkForLineOfThree()){
            for(int ro=0;ro<3;ro++){
                for(int co = 0;co<3;co++){
                    if(spots[ro][co].getLetter()==spots[ro][co+1].getLetter())
                    {poX= ro;

                   if(co==0) poY=co+2;
                   else
                       poY=co-1;
                    break;}
                    if(spots[ro][co].getLetter()==spots[ro+1][co].getLetter()){
                        if(ro==0)poX=ro+2;
                        else
                            poX=ro-1;
                    poY = co;
                    break;}
                    if(spots[ro][co].getLetter()==spots[ro+1][co+1].getLetter()){
                       if(ro==0&&co==0){
                           poX=2;poY=2;
                           break;
                       }
                       else{
                           poX=0;
                           poY=0;break;
                       }
                    }
                    if(spots[ro][co].getLetter()==spots[ro+1][co-1].getLetter()){
                        if(ro==0&&co==2){
                            poX=2;poY=0;
                            break;
                        }
                        else{
                            poX=0;
                            poY=2;break;
                        }
                }
        }}

            spots[poX][poY].setLetter(turn);
            if (checkForLineOfThree()) {
                finishGame(turn);}
            turn = 'x';}

    }

    private void dropInColumn(char turn, int gX,int gY) {
        spots[gX][gY].setLetter(turn);
    }
    private boolean checkForLineOfThree() {
        for (int row = 0; row <3; row++) {
            int inARow = 0;
            char first = spots[row][1].getLetter();
            for (int col = 0; col < 3; col++) {
                char cur = spots[row][col].getLetter();
                if (first == cur && first != ' ')
                    inARow++;
                if (inARow == 3){
                    return true;
                }
            }
        }

        // Vertical
        for (int col = 0; col < 3; col++) {
            int inARow =0;
            char first = spots[0][col].getLetter();
            for (int row = 0; row < 3; row++) {
                char cur = spots[row][col].getLetter();

                if (first == cur && first != ' ')
                    inARow++;

                if (inARow ==3){
                    return true;
                }
            }
        }

        { char first = spots[0][0].getLetter();
            if(first != ' ' && first == spots[1][1].getLetter()&& first == spots[2][2].getLetter())
                return true;}

        {char second = spots[0][2].getLetter();
            if(second != ' ' && second == spots[1][1].getLetter()&& second == spots[2][0].getLetter())
                return true;}

        return false;
    }
    private void finishGame(char turn) {
        Intent inte = new Intent(context, Winner.class);

        inte.putExtra("Winner", turn);

        context.startActivity(inte); }
}

