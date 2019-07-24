package com.example.android.mygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Winner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        char input = getIntent().getCharExtra("Winnner", ' ');
        ImageView cro = (ImageView)findViewById(R.id.imageView6);
        ImageView ze = (ImageView)findViewById(R.id.imageView8);
        TextView winner = (TextView)findViewById(R.id.textView3);
        winner.setText("Winner is player: " + String.valueOf(input) + '!');
        if(input=='x'){
cro.setVisibility(View.VISIBLE);

        }
        if(input=='o'){
            ze.setVisibility(View.VISIBLE);
        }

    }
}
