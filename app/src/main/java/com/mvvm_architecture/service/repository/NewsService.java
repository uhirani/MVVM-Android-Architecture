package com.mvvm_architecture.service.repository;

import com.mvvm_architecture.service.model.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NewsService {

    @GET("viewed/{period}.json")
    Call<News> getArticles(@Path("period") int period);
//    Call<News> getArticles(@Path("period") int period, @Query("api-key") String api_key);
}
