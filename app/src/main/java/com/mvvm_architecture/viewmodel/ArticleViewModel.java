package com.mvvm_architecture.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import com.mvvm_architecture.service.model.News;
import com.mvvm_architecture.service.repository.NewsRepository;


public class ArticleViewModel extends AndroidViewModel {
    private final LiveData<News> newsLiveData;
    public ObservableField<News> news = new ObservableField<>();

    public ArticleViewModel(@NonNull Application application) {
        super(application);
        newsLiveData = NewsRepository.getInstance().getArticles(7);
    }

    public LiveData<News> getObservableArticle() {
        return newsLiveData;
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application application;

        public Factory(@NonNull Application application) {
            this.application = application;
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new ArticleViewModel(application);
        }
    }
}
