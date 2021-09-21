package com.app.gadfixuser.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.app.gadfixuser.Listener.AppListener;
import com.app.gadfixuser.Model.LoginModel.LoginRequest;
import com.app.gadfixuser.Model.LoginModel.LoginResponse;
import com.app.gadfixuser.Network.GadfixApiController;
import com.app.gadfixuser.R;
import com.app.gadfixuser.Utils.StringUtils;
import com.app.gadfixuser.databinding.ActivityLoginBinding;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityLoginBinding binding;
    private GadfixApiController gadfixApiController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_login);
        gadfixApiController=new GadfixApiController(this);

        binding.forgotPassword.setOnClickListener(v -> {
            Intent intent=new Intent(this, ForgotPasswordActivity.class);
            startActivity(intent);
        });

        binding.loginBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_btn:
                if(binding.name.getText().toString().trim().equals("")){
                    Snackbar snackbar = Snackbar.make(v,"Enter phone number",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else if(binding.name.getText().toString().length()<10){
                    Snackbar snackbar = Snackbar.make(v,"Enter Valid Phone Number",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else if(binding.passSignIn.getText().toString().trim().equals("")){
                    Snackbar snackbar = Snackbar.make(v,"Enter password",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else{
                    LoginRequest loginRequest=new LoginRequest();
                    loginRequest.setMno(binding.name.getText().toString());
                    loginRequest.setPassword(binding.passSignIn.getText().toString());
                    gadfixApiController.getLogin(loginRequest, new AppListener.OnLoginListener() {
                        @Override
                        public void onSuccess(LoginResponse loginResponse) {
                            Snackbar snackbar=Snackbar.make(v,loginResponse.getMessage(),Snackbar.LENGTH_LONG);
                            snackbar.show();
                            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                        }

                        @Override
                        public void onFailure(String message) {
                            Snackbar snackbar=Snackbar.make(v,message,Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                    });
                }
        }
    }
}