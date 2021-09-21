package com.app.gadfixuser.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.app.gadfixuser.R;
import com.app.gadfixuser.databinding.ActivityForgotPasswordSetPasswordBinding;

public class ForgotPasswordSetPasswordActivity extends AppCompatActivity {

    private ActivityForgotPasswordSetPasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_forgot_password_set_password);
    }
}