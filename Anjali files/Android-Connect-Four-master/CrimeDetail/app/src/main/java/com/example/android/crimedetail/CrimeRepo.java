package com.example.android.crimedetail;

import android.support.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CrimeRepo { private static final String LANGUAGE = "en-US";

    private static CrimeRepo repository;
    private Police api;
    private static final String BASE_URL = " https://data.police.uk/api/";
    private CrimeRepo(Police api) {
        this.api = api;
    }

    public static CrimeRepo getInstance() {
        if (repository == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            repository = new CrimeRepo(retrofit.create(Police.class));
        }

        return repository;
    }

    public void getMovies(final onCrimeCallBack callback) {
        api.getPopularMovies("<YOUR_API_KEY>", LANGUAGE, 1)
                .enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(@NonNull Call<Model> call, @NonNull Response<Model> response) {
                        if (response.isSuccessful()) {
                            Model moviesResponse = response.body();
                            if (moviesResponse != null && moviesResponse.getCategory() != null) {
                                callback.onSuccess(moviesResponse.getCategory());
                            } else {
                                callback.onError();
                            }
                        } else {
                            callback.onError();
                        }
                    }

                    @Override
                    public void onFailure(Call<MoviesResponse> call, Throwable t) {
                        callback.onError();
                    }
                });
    }
}
}
