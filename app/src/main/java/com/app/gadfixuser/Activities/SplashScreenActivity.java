package com.app.gadfixuser.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;

import com.app.gadfixuser.Preference.SharedPreferenceConfig;
import com.app.gadfixuser.Preference.UserSharedpreference;
import com.app.gadfixuser.R;
import com.app.gadfixuser.Utils.StringUtils;

public class SplashScreenActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    private UserSharedpreference userSharedpreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        userSharedpreference = new UserSharedpreference(this);
        userSharedpreference = userSharedpreference.getInstance(getBaseContext());
        userSharedpreference.saveStringData(SharedPreferenceConfig.DEVICE_ID, StringUtils.getDeviceId(getBaseContext()));
        Log.d("deviceiddd", "onCreate: "+ userSharedpreference.getStringData(SharedPreferenceConfig.DEVICE_ID));
        new Handler().postDelayed(() -> {
            Intent homeIntent = new Intent(SplashScreenActivity.this, IntroActivity.class);
            startActivity(homeIntent);
            finish();
        },SPLASH_TIME_OUT);
    }
}