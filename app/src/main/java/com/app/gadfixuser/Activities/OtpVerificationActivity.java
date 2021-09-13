package com.app.gadfixuser.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.app.gadfixuser.MainActivity;
import com.app.gadfixuser.R;
import com.app.gadfixuser.databinding.ActivityOtpVerificationBinding;

public class OtpVerificationActivity extends AppCompatActivity {

    private ActivityOtpVerificationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_otp_verification);

        binding.btVerify.setOnClickListener(v -> {
            Intent intent=new Intent(OtpVerificationActivity.this, HomeActivity.class);
            startActivity(intent);
        });
    }
}