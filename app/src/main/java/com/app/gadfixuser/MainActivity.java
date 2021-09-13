package com.app.gadfixuser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.app.gadfixuser.Activities.CartActivity;
import com.app.gadfixuser.Activities.HistoryActivity;
import com.app.gadfixuser.Activities.HomeActivity;
import com.app.gadfixuser.Activities.ProfileActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity{

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}