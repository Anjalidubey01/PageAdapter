package com.example.android.mygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Select extends AppCompatActivity {
EditText rows,cols;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        ImageView cro = (ImageView)findViewById(R.id.imageView3);
        ImageView ze = (ImageView)findViewById(R.id.imageView4);
        ImageView smil = (ImageView)findViewById(R.id.imageView5);
        TranslateAnimation animation = new TranslateAnimation(0.0f, 150.0f,78,500.0f);
        animation.setDuration(4000);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(2);
        animation.setFillAfter(true);
        cro.startAnimation(animation);
        ze.setAnimation(animation);
        smil.startAnimation(animation);
        TranslateAnimation anim= new TranslateAnimation(50.0f, -150.0f,50,-500.0f);
        anim.setDuration(4000);
        anim.setRepeatCount(Animation.INFINITE);
        anim.setRepeatMode(2);
        anim.setFillAfter(true);
        cro.startAnimation(anim);
        ze.startAnimation(anim);
        cro.startAnimation(anim);
         rows = (EditText)findViewById(R.id.editText2);
         cols = (EditText)findViewById(R.id.editText);
        Button submit = (Button)findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Select.this, MainActivity.class);

                int row = Integer.parseInt(rows.getText().toString());
                int columns = Integer.parseInt(cols.getText().toString());

                intent.putExtra("rows", row);
                intent.putExtra("columns", columns);

                startActivity(intent);
            }
        });


    }
}
