package com.mvvm_architecture.view.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mvvm_architecture.R;
import com.mvvm_architecture.databinding.ActivityArticleDetailBinding;
import com.mvvm_architecture.service.model.Article;

public class ArticleDetailActivity extends AppCompatActivity {
    private ActivityArticleDetailBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Article article = (Article) getIntent().getSerializableExtra("ArticleObj");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(article.getTitle());

        binding = DataBindingUtil.setContentView(this, R.layout.activity_article_detail);
        binding.setUrl(getIntent().getStringExtra("url"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
