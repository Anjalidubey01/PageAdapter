package com.example.android.mygame;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.Button;


public class RulesAndGrids extends SurfaceView implements Runnable {
    volatile boolean playing;
    private Thread gameThread = null;
    int Rows,cols;
    Canvas canvas;
    Context context;
    private int screenWidth,screenHeight;
    public DrawGrid[][] cells;
    private int increment;
    private int xMargin;
    private int yMargin = 400;
    Bitmap xImage,oImage,xImg,oImg,Reset;
    SurfaceHolder surfaceHolder;
    char turn;
    Paint paint,anit;
    Button  button;
    public RulesAndGrids(Context context,int Rows,int cols){
        super(context);
        playing = true;
       this.Rows=Rows;
        this.cols = cols ;
        this.context = context;
        xImage = BitmapFactory.decodeResource(context.getResources(),R.drawable.cro);
        oImage = BitmapFactory.decodeResource(context.getResources(),R.drawable.ze);
        oImg = BitmapFactory.decodeResource(context.getResources(),R.drawable.pink);
        xImg = BitmapFactory.decodeResource(context.getResources(),R.drawable.green);
        Reset = BitmapFactory.decodeResource(context.getResources(),R.drawable.reset);
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        anit = new Paint();
        anit.setColor(Color.BLUE);
        anit.setTextSize(35);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        surfaceHolder = getHolder();
        screenWidth = size.x;
        screenHeight = size.y;
        increment  = screenWidth / (cols+ 2);
        xMargin = increment;
        cells = new DrawGrid[Rows][cols];
        turn = 'x';

        for (int row = 0; row < Rows; row++)
            for (int col = 0; col < cols; col++) {
                DrawGrid curCell = new DrawGrid(xMargin + increment * col, yMargin + increment * row, xMargin + increment * (col + 1), yMargin + increment * (row + 1), xImage, oImage,xImg,oImg);
                cells[row][col] = curCell;
            }

    }


    @Override
    public void run() {
        while(playing){
            //update();
            drawBoard();
            control();
        }
    }

    //private void update() {
      //  for(int rows=0;rows<Rows;rows++)
        //    for(int col=0;col<cols;col++){
          //      cells[rows][col].update();
            //} }
    private void drawBoard() {
        if (surfaceHolder.getSurface().isValid()) {
            canvas = surfaceHolder.lockCanvas();
            canvas.drawColor(Color.WHITE);
             for(int rows=0;rows<Rows;rows++)
             for(int col = 0;col<cols;col++){
               cells[rows][col].draw(canvas,paint);
               }

            canvas.drawText("PLAYER X", 0, canvas.getWidth()/5,anit );
            canvas.drawText("PLAYER 0", canvas.getWidth()/2, canvas.getWidth()/5, anit);
            canvas.drawBitmap(xImage,null,new Rect(canvas.getWidth()/4,canvas.getWidth()/8,canvas.getWidth()/3,canvas.getWidth()/4),null);
            canvas.drawBitmap(oImage,null,new Rect(3*canvas.getWidth()/4,canvas.getWidth()/8,5*canvas.getWidth()/6,canvas.getWidth()/4),null);
           canvas.drawBitmap(Reset,null,new Rect(3*canvas.getWidth()/4,6*canvas.getHeight()/8,canvas.getWidth(),7*canvas.getHeight()/8),null);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }

    }
    private void control(){
        try {
            gameThread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void pause() {
        playing = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
        }
    }

    public void resume() {
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public boolean onTouchEvent( MotionEvent event) {
        if (event.getAction() != MotionEvent.ACTION_DOWN)
            return false;

        int x = (int) event.getX();
        int y = (int) event.getY();
        if(x<canvas.getWidth()&&x>3*canvas.getWidth()/4&&y<7*canvas.getHeight()/8&&y>6*canvas.getHeight()/8)
            for(int i=0;i<Rows;i++)
                for(int j = 0;j<cols;j++)
                    cells[i][j].setLetter(' ');
        for(int gX = 0; gX < cells.length; gX++){
            for(int gY = 0; gY < cells[gX].length; gY++){
                DrawGrid gridCell = cells[gX][gY];
                if(x > gridCell.getX1() && x < gridCell.getX2())
                    if(y > gridCell.getY1() && y < gridCell.getY2()) {
                        dropInColumn(turn, gY);
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
        for(int i = cells.length - 1; i > -1; i--){
            if(cells[i][dropColumn].getLetter() == ' '){
                cells[i][dropColumn].setLetter(letter);
                break;
            }
        }
    }

    private void finishGame(char turn) {
        Intent intent = new Intent(context, Winner.class);
        intent.putExtra("Winnner", turn);
        context.startActivity(intent);

    }

    private boolean checkForLineOfFour() {
        for (int row = 0; row < cells.length; row++) {
            int inARow = 0;
            char first = cells[row][1].getLetter();
            for (int col = 0; col < cells[row].length; col++) {
                char cur = cells[row][col].getLetter();
                //if(cells[row][col].getO()!=null||cells[row][col].getX()!=null){

                if (first == cur && first != ' ')
                    inARow++;
                else {
                    first = cur;
                    inARow = 1;
                }

                if (inARow == 4){
                    return true;
                }

        }}

        // Vertical
        for (int col = 0; col < cells[0].length; col++) {
            int inARow = 0;
            char first = cells[1][col].getLetter();
            for (int row = 0; row < cells.length; row++) {
                char cur = cells[row][col].getLetter();
                //if(cells[row][col].getO()!=null||cells[row][col].getX()!=null){
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
        for (int col = 0; col < cells[0].length; col++) {
            for (int row = 0; row < cells.length; row++) {
                char first = cells[row][col].getLetter();
               // if(cells[row][col].getO()!=null||cells[row][col].getX()!=null){
                int inARow = 1;
                for (int diagonal = 1; diagonal <= 4; diagonal++) {
                    if (row + diagonal < Rows && col + diagonal < cols) {
                        char cur = cells[row + diagonal][col + diagonal].getLetter();

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
                    if (row - diagonal > 0 && col + diagonal < cols) {
                        char cur = cells[row - diagonal][col + diagonal].getLetter();

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
        //    }
        }
        }

        return false;
    }


}



