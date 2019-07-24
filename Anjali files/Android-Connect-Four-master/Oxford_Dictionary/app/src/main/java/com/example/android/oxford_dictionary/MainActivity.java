package com.example.android.oxford_dictionary;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
EditText input;
Button button;
String word_id;
TextView eti,word,word2;
model userListResponseData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);
        eti=(TextView)findViewById(R.id.textView3);
        word=(TextView)findViewById(R.id.textView);
        word2=(TextView)findViewById(R.id.textView4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              word_id=input.getText().toString().toLowerCase();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Api.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                        .build();
                Api api = retrofit.create(Api.class);
                Call<model> call = api.getforces(word_id,"etymologies","false");

                call.enqueue(new Callback<model>() {
                    @Override
                    public void onResponse(Call<model> call, Response<model> response) {

                        userListResponseData= response.body();
                        eti.setVisibility(View.VISIBLE);
                        word.setVisibility(View.VISIBLE);
                        word2.setVisibility(View.VISIBLE);
                        word2.setText(word_id.toUpperCase());
                        eti.setText(userListResponseData.getResults().get(0).getLexicalEntries().get(0).getEntries().get(0).getEtymologies().get(0));
                    }
                    @Override
                    public void onFailure(Call<model> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }});}
            });

    }
}
