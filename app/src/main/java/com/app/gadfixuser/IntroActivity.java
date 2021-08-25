package com.app.gadfixuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.app.gadfixuser.Activities.LoginActivity;
import com.app.gadfixuser.databinding.ActivityIntroBinding;

public class IntroActivity extends AppCompatActivity {

    private ActivityIntroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_intro);

        binding.signIn.setOnClickListener(v -> {
            Intent intent=new Intent(this, LoginActivity.class);
            startActivity(intent);
        });

        binding.registerBtn.setOnClickListener(v -> {
            Intent intent=new Intent(this,RegistrationActivity.class);
            startActivity(intent);
        });
    }

}