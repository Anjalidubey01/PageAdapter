package com.example.android.crimedetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Police {
    @GET("crimes-at-location")
    Call<Model> getPopularMovies(
            @Query("lat") String apiKey,
            @Query("lng") String language,
            @Query("date") int page);
}
