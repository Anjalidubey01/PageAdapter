package com.example.android.oxford_dictionary;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL = "https://od-api.oxforddictionaries.com/api/v2/";
   @Headers({"app_id: 441debdb","app_key: 70d4f91d04d5ff1c88b8524ad81dbea5"})
    @GET("entries/en-gb/{word_id}")
    Call<model> getforces(@Path("word_id") String word, @Query("fields") String fields,@Query("strictMatch") String strict);
}
