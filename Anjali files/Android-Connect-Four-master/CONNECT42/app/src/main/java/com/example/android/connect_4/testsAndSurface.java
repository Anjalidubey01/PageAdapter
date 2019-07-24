package com.example.android.connect_4;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

public class testsAndSurface extends SurfaceView implements Runnable {
    volatile boolean playing = true;
    SurfaceHolder surfaceHolder;
    Canvas canvas;
    private Thread gameThread = null;
    public GridsSquare[][] spots;
    Context context;
    private int rows, columns;
    private Paint paint,anit;
    private int screenWidth,screenHeight;
    private int increment;
    private int xMargin;
    private int yMargin = 50;
    private char turn;
    private Bitmap xImage;
    private Bitmap oImage;

    public testsAndSurface(Context context,int rows,int columns) {
        super(context);
        surfaceHolder = getHolder();
        xImage = BitmapFactory.decodeResource(context.getResources(),R.drawable.cro);
        oImage = BitmapFactory.decodeResource(context.getResources(),R.drawable.ze);

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
        increment  = screenWidth / (columns + 2);
        xMargin = increment;
        spots = new GridsSquare[rows][columns];
        this.context = context;
        this.rows = rows;
        this.columns = columns;
        turn = 'x';

        for (int row = 0; row < rows; row++)
            for (int col = 0; col < columns; col++) {
                GridsSquare curCell = new GridsSquare(xMargin + increment * col, yMargin + increment * row, xMargin + increment * (col + 1), yMargin + increment * (row + 1), xImage, oImage);

                spots[row][col] = curCell;
            }
    }

    @Override
    public void run() {
        while (playing){
            update();
            drawB();
            control();
        }
    }

    private void control() {
        try {
            gameThread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void update() {
        for(int row = 0;row<rows;row++)
          for(int col = 0;col<columns;col++)
                 spots[row][col].update();}
    private void drawB(){
        if(surfaceHolder.getSurface().isValid()){
           canvas = surfaceHolder.lockCanvas();
           canvas.drawColor(Color.CYAN);
            for (int row = 0; row < rows; row++)
                for (int col = 0; col < columns; col++){
                    spots[row][col].draw(canvas, paint);
                    if(spots[row][col].getLetter()!=' '){
                        if(spots[row][col].getLetter()=='x'){
                            canvas.drawBitmap(xImage,null,new Rect((int)spots[row][col].getX1(),spots[row][col].getY3(),(int)spots[row][col].getX2(),spots[row][col].getY4()),null);
                        }

                    }
                }
            canvas.drawText("PLAYER X", canvas.getWidth()/2, canvas.getWidth(), anit);
            canvas.drawText("PLAYER 0", canvas.getWidth()/2, 8*canvas.getWidth()/7, anit);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public boolean onTouchEvent( MotionEvent event) {
        if (event.getAction() != MotionEvent.ACTION_DOWN)
            return false;

        int x = (int) event.getX();
        int y = (int) event.getY();
        Log.d("keyboard", "x pos: " + x);
        Log.d("keyboard", "y pos: " + y);
        for(int gX = 0; gX < spots.length; gX++){
            for(int gY = 0; gY < spots[gX].length; gY++){
                GridsSquare gridCell = spots[gX][gY];
                if(x > gridCell.getX1() && x < gridCell.getX2())
                    if(y > gridCell.getY1() && y < gridCell.getY2()) {
                        dropInColumn(turn, gY);
                        Log.d("test", "Placed a letter: " + turn);


                        if (checkForLineOfFour()) {
                            finishGame(turn);
                        }

                        turn = (turn == 'x') ? 'o' : 'x';

                        postInvalidate();
                        return true;
                    }
            }
        }
        return false;
    }

    private void dropInColumn(char letter, int dropColumn){
        for(int i = spots.length - 1; i > -1; i--){
            if(spots[i][dropColumn].getLetter() == ' '){
                spots[i][dropColumn].setLetter(letter);
                break;
            }
        }
    }

    private void finishGame(char turn) {
        Intent intent = new Intent(context,Final.class);

        intent.putExtra("Winnner", turn);

        context.startActivity(intent);
    }

    private boolean checkForLineOfFour() {
        for (int row = 0; row < spots.length; row++) {
            int inARow = 0;
            char first = spots[row][1].getLetter();
            for (int col = 0; col < spots[row].length; col++) {
                char cur = spots[row][col].getLetter();

                if (first == cur && first != ' ')
                    inARow++;
                else {
                    first = cur;
                    inARow = 1;
                }

                if (inARow == 4){
                    return true;
                }
            }
        }

        // Vertical
        for (int col = 0; col < spots[0].length; col++) {
            int inARow = 0;
            char first = spots[1][col].getLetter();
            for (int row = 0; row < spots.length; row++) {
                char cur = spots[row][col].getLetter();

                if (first == cur && first != ' ')
                    inARow++;
                else {
                    first = cur;
                    inARow = 1;
                }

                if (inARow ==4){
                    return true;
                }
            }
        }

        // Forward Diagonal
        System.out.println();
        for (int col = 0; col < spots[0].length; col++) {
            for (int row = 0; row < spots.length; row++) {
                char first = spots[row][col].getLetter();
                int inARow = 1;
                for (int diagonal = 1; diagonal <= 4; diagonal++) {
                    if (row + diagonal < rows && col + diagonal < columns) {
                        char cur = spots[row + diagonal][col + diagonal].getLetter();

                        if (first == cur && first != ' ')
                            inARow++;
                        else {
                            first = cur;
                            inARow = 1;
                        }

                        if (inARow == 4) {
                            return true;
                        }
                    }
                }

                inARow = 1;
                for (int diagonal = 1; diagonal <= 4; diagonal++) {
                    if (row - diagonal > 0 && col + diagonal < columns) {
                        char cur = spots[row - diagonal][col + diagonal].getLetter();

                        if (first == cur && first != ' ')
                            inARow++;
                        else {
                            first = cur;
                            inARow = 1;
                        }

                        if (inARow == 4) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

}
