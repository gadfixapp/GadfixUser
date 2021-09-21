package com.app.gadfixuser.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.app.gadfixuser.Listener.AppListener;
import com.app.gadfixuser.Model.RegistrationModel.RegistrationRequest;
import com.app.gadfixuser.Model.RegistrationModel.RegistrationResponse;
import com.app.gadfixuser.Network.GadfixApiController;
import com.app.gadfixuser.Preference.SharedPreferenceConfig;
import com.app.gadfixuser.Preference.UserSharedpreference;
import com.app.gadfixuser.R;
import com.app.gadfixuser.Utils.StringUtils;
import com.app.gadfixuser.databinding.ActivityRegistrationBinding;
import com.google.android.material.snackbar.Snackbar;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityRegistrationBinding binding;
    private GadfixApiController gadfixApiController;
    private UserSharedpreference userSharedpreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_registration);
        gadfixApiController = new GadfixApiController(this);
        userSharedpreference = new UserSharedpreference(this);

        binding.signIn.setOnClickListener(v -> {
            Intent intent=new Intent(RegistrationActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        binding.registerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_btn:
                if (binding.name.getText().toString().trim().equals("")){
                    Snackbar snackbar = Snackbar.make(v,"Enter Your Full Name",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else if(binding.mail.getText().toString().trim().equals("")){
                    Snackbar snackbar = Snackbar.make(v,"Enter mail addess",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }else if (!StringUtils.isEmailValid(binding.mail.getText().toString())){
                    Snackbar snackbar = Snackbar.make(v,"Enter valid mail addess",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else if(binding.ph.getText().toString().trim().equals("")){
                    Snackbar snackbar = Snackbar.make(v,"Enter Your Phone Number",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else if(binding.ph.getText().toString().length()<10){
                    Snackbar snackbar = Snackbar.make(v,"Enter Valid Phone Number",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else if(binding.pass.getText().toString().trim().equals("")){
                    Snackbar snackbar = Snackbar.make(v,"Enter Password",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else if(!StringUtils.isValidPassword(binding.pass.getText().toString())){
                    Snackbar snackbar = Snackbar.make(v,"Password must be greater than 8 character",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else if(binding.repass.getText().toString().trim().equals("")){
                    Snackbar snackbar = Snackbar.make(v,"Reenter password",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else if(!binding.pass.getText().toString().equals(binding.repass.getText().toString())){
                    Snackbar snackbar = Snackbar.make(v,"Enter correct password",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else
                {
                    RegistrationRequest registrationRequest = new RegistrationRequest();
                    registrationRequest.setName(binding.name.getText().toString());
                    registrationRequest.setEmail(binding.mail.getText().toString());
                    registrationRequest.setMno(binding.ph.getText().toString());
                    registrationRequest.setPassword(binding.pass.getText().toString());
                    registrationRequest.setReferal(binding.code.getText().toString());
                    gadfixApiController.getRegistration(registrationRequest, new AppListener.OnRegistrationListener() {
                        @Override
                        public void onSuccess(RegistrationResponse registrationResponse) {
                            Snackbar snackbar = Snackbar.make(v,registrationResponse.getMessage(),Snackbar.LENGTH_LONG);
                            snackbar.show();
                            userSharedpreference.saveStringData(SharedPreferenceConfig.USER_MOBILE, registrationResponse.getData().getMobileNo());
                            startActivity(new Intent(RegistrationActivity.this,OtpVerificationActivity.class));
                        }

                        @Override
                        public void onFailure(String message) {
                            Snackbar snackbar = Snackbar.make(v,message,Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                    });

                }

        }
    }
}