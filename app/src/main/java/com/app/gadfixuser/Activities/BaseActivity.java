package com.app.gadfixuser.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.app.gadfixuser.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    protected BottomNavigationView navView;
    protected T binding;
    private View baseView;
    private ViewGroup mContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        baseView=getLayoutInflater().inflate(R.layout.activity_base,null,false);
        setContentView(baseView);

        binding= DataBindingUtil.inflate(getLayoutInflater(),getContentViewId(),(ViewGroup)baseView,false);
        mContainer=findViewById(R.id.container);
        mContainer.addView(binding.getRoot());

        navView=(BottomNavigationView)findViewById(R.id.bt_nav_view);
        navView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateNavigationBarState();
    }

    private void updateNavigationBarState() {
        int actionId=getNavigationMenuItemId();
        selectBottomNavigationBarItem(actionId);
    }

    protected abstract int getNavigationMenuItemId();

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0,0);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        navView.postDelayed(() -> {
            int itemId=item.getItemId();

            if(itemId==R.id.user_home){
                startActivity(new Intent(this,HomeActivity.class));
            }
            else if(itemId==R.id.user_history){
                startActivity(new Intent(this,HistoryActivity.class));
            }
            else if(itemId==R.id.user_cart){
                startActivity(new Intent(this,CartActivity.class));
            }
            else if(itemId==R.id.user_profile){
                startActivity(new Intent(this,ProfileActivity.class));
            }
            finish();
        }, 300);
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    void selectBottomNavigationBarItem(int itemId){
        MenuItem item=navView.getMenu().findItem(itemId);
        item.setChecked(true);
    }

    protected abstract int getContentViewId();

}