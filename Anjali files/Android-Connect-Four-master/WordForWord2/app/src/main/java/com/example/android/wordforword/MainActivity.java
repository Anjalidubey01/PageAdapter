package com.example.android.wordforword;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import retrofit2.Retrofit;
        import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView user,comp;
    Button button;
    String us;
    char d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (TextView)findViewById(R.id.UserWord);
        comp = (TextView)findViewById(R.id.CompWord);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWord();
            }
        });

    }
    public void getWord(){
      us = user.getText().toString();
      d = us.charAt(us.length()-1);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(datamuse.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();
        datamuse api = retrofit.create(datamuse.class);

    }
}
