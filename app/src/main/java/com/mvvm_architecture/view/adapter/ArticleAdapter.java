package com.mvvm_architecture.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mvvm_architecture.R;
import com.mvvm_architecture.databinding.ArticleListItemBinding;
import com.mvvm_architecture.service.model.Article;
import com.mvvm_architecture.view.callback.OnClickCallback;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private final String TAG = ArticleAdapter.class.getSimpleName();
    private List<? extends Article> articleList;

    public void setArticleList(final List<? extends Article> articleList) {
            this.articleList = articleList;
            notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ArticleListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.article_list_item, parent, false);
        binding.setCallback(new OnClickCallback());
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setArticle(articleList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return articleList == null ? 0 : articleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        final ArticleListItemBinding binding;
        public ViewHolder(@NonNull ArticleListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
