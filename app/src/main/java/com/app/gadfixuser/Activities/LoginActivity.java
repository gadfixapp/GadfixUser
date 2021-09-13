package com.app.gadfixuser.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.app.gadfixuser.R;
import com.app.gadfixuser.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_login);

        binding.forgotPassword.setOnClickListener(v -> {
            Intent intent=new Intent(this, ForgotPasswordActivity.class);
            startActivity(intent);
        });
    }
}