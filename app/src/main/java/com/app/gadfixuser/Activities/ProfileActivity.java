package com.app.gadfixuser.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.app.gadfixuser.R;
import com.app.gadfixuser.databinding.ActivityProfileBinding;

public class ProfileActivity extends BaseActivity<ActivityProfileBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getNavigationMenuItemId() {
        return R.id.user_profile;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_profile;
    }
}