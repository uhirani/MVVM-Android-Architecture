package com.mvvm_architecture.service.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.google.gson.Gson;
import com.mvvm_architecture.service.model.News;
import com.mvvm_architecture.utility.Constants;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NewsRepository {
    private NewsService newsService;
    private static NewsRepository newsRepository;

    public NewsRepository() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();
                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter("api-key", "WD4mAFi4Sq1JBODj3xOyqGy5pHugE5gs")
                        .build();

                Request request = original.newBuilder()
                        .url(url).build();
                return chain.proceed(request);
            }
        });
        httpClient.addInterceptor(logging);

        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        newsService = mRetrofit.create(NewsService.class);
    }

    public synchronized static NewsRepository getInstance() {
        if (newsRepository == null) {
            if (newsRepository == null) {
                newsRepository = new NewsRepository();
            }
        }
        return newsRepository;
    }

    /**
     * Get list of most popular NY Times articles
     * @param period It gives result of given periods
     * @return  Returns list of most popular articles of given period
     */
    public LiveData<News> getArticles(int period){
        final MutableLiveData<News> data = new MutableLiveData<>();
        newsService.getArticles(period).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if (response.isSuccessful())
                    Log.e("Success", new Gson().toJson(response.body()));
                else
                    Log.e("unSuccess", new Gson().toJson(response.errorBody()));
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<News> call, Throwable t)
            {
                Log.e("Failure", t.toString());
                data.setValue(null);
            }
        });
        return data;
    }
}
