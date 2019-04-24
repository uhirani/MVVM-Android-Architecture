package com.mvvm_architecture.view.callback;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.mvvm_architecture.service.model.Article;
import com.mvvm_architecture.view.ui.ArticleDetailActivity;

public class OnClickCallback {
    public void onClick(View view, Article article){
        Context mContext = view.getContext();
        Intent intent = new Intent(mContext, ArticleDetailActivity.class);
        intent.putExtra("url", article.getUrl());
        intent.putExtra("ArticleObj", article);
        mContext.startActivity(intent);
    }
}
