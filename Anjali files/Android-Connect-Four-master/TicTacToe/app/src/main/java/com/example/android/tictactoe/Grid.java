package com.example.android.tictactoe;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class Grid extends View implements View.OnTouchListener{
    private Paint paint,anit,red,yellow;
    Canvas canvas;
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
    TextView textView,textView1;
    int time;
    long k,l,m;
    Bitmap cros,zer;

    public Grid(Context context) {
        super(context);
        cross = getResources().getDrawable(R.drawable.cro);
        cros = BitmapFactory.decodeResource(context.getResources(),R.drawable.cro);
        zer = BitmapFactory.decodeResource(context.getResources(),R.drawable.ze);

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
        this.canvas = canvas;
        canvas.drawColor(Color.CYAN);
        for (int row = 0; row < 3; row++)
            for (int col = 0; col <3; col++)
                spots[row][col].draw(canvas, paint);
            Paint anit = new Paint();
            anit.setColor(Color.BLUE);
            anit.setTextSize(30);
        canvas.drawText("PLAYER X", canvas.getWidth()/5, 8*canvas.getWidth()/7, anit);
        canvas.drawText("PLAYER 0", canvas.getWidth()/5, 4*canvas.getWidth()/3, anit);
        canvas.drawBitmap(cros,null,new Rect(canvas.getWidth()/2,15*canvas.getWidth()/14,3*canvas.getWidth()/4,6*canvas.getWidth()/5),null);

        canvas.drawBitmap(zer,null,new Rect(canvas.getWidth()/2,5*canvas.getWidth()/4,3*canvas.getWidth()/4,7*canvas.getWidth()/5),null);

        new CountDownTimer(600000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
               k = (int)millisUntilFinished/1000;
               l = 9-((int)k/60);
               m = 60-(k%60);

            }

            @Override
            public void onFinish() {

            }
        }.start();
        LinearLayout linearLayout = new LinearLayout(context);
        textView = new TextView(context);
        textView.setVisibility(View.VISIBLE);
        linearLayout.addView(textView);
        textView.setText("TIMER-"+l+":"+m);
        textView1 = new TextView(context);
        textView1.setVisibility(GONE);
        textView1.setText("It's DRAW");
        textView1.setTextSize(500);
        linearLayout.addView(textView1);
        linearLayout.measure(canvas.getWidth(),canvas.getHeight());
        linearLayout.layout(0, 0, canvas.getWidth(), canvas.getHeight());
        canvas.translate(500, 600);
        linearLayout.draw(canvas);



    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() != MotionEvent.ACTION_DOWN)
            return false;

        int x = (int) event.getX();
        int y = (int) event.getY();
        Log.d("keyboard", "x pos: " + x);
        Log.d("keyboard", "y pos: " + y);
        for(int i = 0;i<3;i++)
            for(int j = 0;j<3;j++)
                if(spots[i][j].getLetter()!=' ')
                    textView1.setVisibility(VISIBLE);

        for(int gX = 0; gX < spots.length; gX++){
            for(int gY = 0; gY < spots[gX].length; gY++){
                GridLines gridCell = spots[gX][gY];
                if(x > gridCell.getX1() && x < gridCell.getX2())
                    if(y > gridCell.getY1() && y < gridCell.getY2()) {
                        if(turn == 'x'){if(!checkForLineOfThree())
                        dropInColumn(turn,gX, gY);}
                        if (checkForLineOfThree() ) {
                            finishGame(turn);
                        }
                        if(!checkForLineOfThree()&&turn == 'x'){
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
        int poX;
        int poY;
    if(!checkForLineOfThree()){ do{
           poX = re.nextInt(3);
           poY = re.nextInt(3);
      }while(spots[poX][poY].getLetter()!=' ');
      spots[poX][poY].setLetter(turn);
        if (checkForLineOfThree()) {
            finishGame(turn);}
            }
    if(!checkForLineOfThree())turn ='x';

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
        Intent intent = new Intent(context, Winner.class);
        time = (int)((l*60)+m);
        intent.putExtra("Winnner", turn);
        intent.putExtra("time",time);

        context.startActivity(intent); }


}

