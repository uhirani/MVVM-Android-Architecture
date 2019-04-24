package com.mvvm_architecture.view.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.mvvm_architecture.R;
import com.mvvm_architecture.lifecycle.SomeObserver;

public class ArticlesListActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();
    private DrawerLayout dl;
    private NavigationView nv;
    private ActionBarDrawerToggle dt;
    private int selectedItem = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle(R.string.title);
        setContentView(R.layout.activity_articles_list);

        dl = findViewById(R.id.drawer_layout);
        dt = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
        dl.addDrawerListener(dt);
        dt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.account:
                        Toast.makeText(ArticlesListActivity.this, R.string.menu_account,Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.settings:
                        Toast.makeText(ArticlesListActivity.this, R.string.menu_setting,Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        if(savedInstanceState == null){
            ArticleListFragment fragment = new ArticleListFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
        getLifecycle().addObserver(new SomeObserver());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
//        MenuItem mitem=menu.findItem(R.id.action_period);
//        Spinner spPeriod = (Spinner)mitem.getActionView();
//        setSpinnerItem(spPeriod);
        return true;
    }

//    public void setSpinnerItem(final Spinner spinnerItem){
//        String[] period = {" 1 ", " 7 ", " 30 "};
//        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
//                (this, R.layout.actionbar_spinner,
//                        period); //selected item will look like a spinner set from XML
//        spinnerArrayAdapter.setDropDownViewResource(R.layout.actionbar_spinner_dropdown);
//        spinnerItem.setAdapter(spinnerArrayAdapter);
//
//        spinnerItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                //call API
//                Toast.makeText(ArticlesListActivity.this, spinnerItem.getSelectedItem()+"", Toast.LENGTH_SHORT).show();
//                ArticleListFragment fragment = new ArticleListFragment();
//                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(dt.onOptionsItemSelected(item)){
            return true;
        }
        switch (item.getItemId()){
            case R.id.action_search:
                break;
            case R.id.action_settings:
                break;
            default:
                break;
        }
        return true;
    }
}
