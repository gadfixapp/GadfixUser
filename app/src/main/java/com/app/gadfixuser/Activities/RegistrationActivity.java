package com.app.gadfixuser.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.app.gadfixuser.R;
import com.app.gadfixuser.databinding.ActivityRegistrationBinding;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegistrationBinding binding= DataBindingUtil.setContentView(this, R.layout.activity_registration);

        binding.signIn.setOnClickListener(v -> {
            Intent intent=new Intent(RegistrationActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        binding.registerBtn.setOnClickListener(v -> {
            Intent intent=new Intent(RegistrationActivity.this, OtpVerificationActivity.class);
            startActivity(intent);
        });
    }
}