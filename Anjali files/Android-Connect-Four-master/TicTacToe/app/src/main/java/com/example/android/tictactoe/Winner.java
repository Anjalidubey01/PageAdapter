package com.example.android.tictactoe;

import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Winner extends AppCompatActivity {
    private ImageView cross,zero;
    int time,k,l,min;
    int[] times = new int[100];
    int a = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        int input = getIntent().getIntExtra("time",0);
        char intr = getIntent().getCharExtra("Winnner",' ');
        times[0]=0;
        times[a] = input;
        a++;
        setContentView(R.layout.activity_winner);
        TextView textView = (TextView) findViewById(R.id.textView4);
        TextView textView2= (TextView) findViewById(R.id.textView6);
        cross = (ImageView)findViewById(R.id.imageView) ;
        zero = (ImageView)findViewById(R.id.imageView3);
        SharedPreferences myPrefs =getSharedPreferences("time",MODE_PRIVATE);
        textView.setText("Winner is player: " + String.valueOf(intr) + '!');
        if(intr =='o'){
            zero.setVisibility(View.VISIBLE); }
        else {
            cross.setVisibility(View.VISIBLE);
        }
        min = times[1];
       for(int i = 1;i<100;i++){
           if(times[a]>min)
               min = times[a];
       }
        SharedPreferences.Editor editor =myPrefs.edit();
        editor.putInt("timer",min);
        editor.apply();
        time = myPrefs.getInt("timer",0);
        k = time/60;
        l = time%60;
        textView2.setText("0"+k+":"+l);
        //SharedPreferences sharedPreferences = getSharedPreferences("time",MODE_WORLD_READABLE);
        //time = sharedPreferences.getInt("time",MODE_WORLD_READABLE);

    }
}
