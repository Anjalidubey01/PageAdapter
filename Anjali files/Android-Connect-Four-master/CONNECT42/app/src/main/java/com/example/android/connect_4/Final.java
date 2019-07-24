package com.example.android.connect_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Final extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        char input = getIntent().getCharExtra("Winnner", ' ');
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Winner is player: " + String.valueOf(input) + '!');
    }
}
