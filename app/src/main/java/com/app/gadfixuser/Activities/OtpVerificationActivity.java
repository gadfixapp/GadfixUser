package com.app.gadfixuser.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.app.gadfixuser.Listener.AppListener;
import com.app.gadfixuser.MainActivity;
import com.app.gadfixuser.Model.OTPVerificationModel.OtpVerificationRequest;
import com.app.gadfixuser.Model.OTPVerificationModel.OtpVerificationResponse;
import com.app.gadfixuser.Network.GadfixApiController;
import com.app.gadfixuser.Preference.SharedPreferenceConfig;
import com.app.gadfixuser.Preference.UserSharedpreference;
import com.app.gadfixuser.R;
import com.app.gadfixuser.databinding.ActivityOtpVerificationBinding;
import com.google.android.material.snackbar.Snackbar;

public class OtpVerificationActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityOtpVerificationBinding binding;
    private GadfixApiController gadfixApiController;
    private UserSharedpreference userSharedpreference;
    private String mobileNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_otp_verification);

        gadfixApiController=new GadfixApiController(this);
        userSharedpreference = new UserSharedpreference(this);

        mobileNo = userSharedpreference.getStringData(SharedPreferenceConfig.USER_MOBILE);
        binding.btVerify.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_verify:
                if(binding.pinviewuser.getValue().equals("")){
                    Snackbar snackbar=Snackbar.make(v,"Enter your OTP",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else
                {
                    OtpVerificationRequest otpVerificationRequest=new OtpVerificationRequest();
                    otpVerificationRequest.setOtp(binding.pinviewuser.getValue());
                    otpVerificationRequest.setMno(mobileNo);
                    gadfixApiController.getOtpVerification(otpVerificationRequest, new AppListener.OnOtpVerificationListener() {
                        @Override
                        public void onSuccess(OtpVerificationResponse otpVerificationResponse) {
                            Snackbar snackbar=Snackbar.make(v,"OTP verified Successfully",Snackbar.LENGTH_LONG);
                            snackbar.show();
                            startActivity(new Intent(OtpVerificationActivity.this,HomeActivity.class));
                        }

                        @Override
                        public void onFailure(String message) {
                            Snackbar snackbar=Snackbar.make(v,"Enter correct OTP",Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                    });
                }
        }
    }
}