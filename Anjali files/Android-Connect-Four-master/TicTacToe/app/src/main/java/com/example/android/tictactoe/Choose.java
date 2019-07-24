package com.example.android.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choose extends AppCompatActivity {
    private Button easy,Medi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        easy = (Button)findViewById(R.id.button);
        Medi= (Button)findViewById(R.id.button2);
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inta = new Intent(Choose.this,gameBoard.class);
                startActivity(inta);
            }
        });
        Medi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ik=new Intent(Choose.this,InterMediate.class);
                startActivity(ik);
            }
        });

    }
}
