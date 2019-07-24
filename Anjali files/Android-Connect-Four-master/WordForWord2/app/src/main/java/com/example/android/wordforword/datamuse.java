package com.example.android.wordforword;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface datamuse {
    String BASE_URL = "https://api.datamuse.com/";
    @GET("words")
    Call<List<WordList>>getWords(@Query("d")char d);
      }
