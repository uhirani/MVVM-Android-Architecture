package com.mvvm_architecture.view.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mvvm_architecture.R;
import com.mvvm_architecture.databinding.FragmentArticleListBinding;

import com.mvvm_architecture.service.model.News;
import com.mvvm_architecture.view.adapter.ArticleAdapter;
import com.mvvm_architecture.viewmodel.ArticleViewModel;

public class ArticleListFragment extends Fragment {
    private ArticleAdapter adapter;
    private FragmentArticleListBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_article_list, container, false);
        adapter = new ArticleAdapter();
        binding.articleList.setAdapter(adapter);
        binding.setIsLoading(true);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        ArticleViewModel.Factory factory = new ArticleViewModel.Factory(
                getActivity().getApplication());

        ArticleViewModel viewModel = ViewModelProviders.of(this, factory)
                .get(ArticleViewModel.class);
        binding.setIsLoading(true);
        observeViewModel(viewModel);

        super.onActivityCreated(savedInstanceState);
    }

    private void observeViewModel(ArticleViewModel articleViewModel){
        articleViewModel.getObservableArticle().observe(this, new Observer<News>() {
            @Override
            public void onChanged(@Nullable News nyNews) {
                if(nyNews != null){
                    binding.setIsLoading(false);
                    adapter.setArticleList(nyNews.getArticles());
                }
            }
        });
    }
}
