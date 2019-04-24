package com.mvvm_architecture.view.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mvvm_architecture.R;

public class MainActivity extends AppCompatActivity {

    /** Duration of wait **/
    private final int SPLASH_TIME = 2000;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent nyArticleList = new Intent(mContext, ArticlesListActivity.class);
                startActivity(nyArticleList);
                finish();
            }
        }, SPLASH_TIME);
    }
}
