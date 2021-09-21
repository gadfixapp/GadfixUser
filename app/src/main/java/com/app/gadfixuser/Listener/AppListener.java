package com.app.gadfixuser.Listener;


import com.app.gadfixuser.Model.LoginModel.LoginResponse;
import com.app.gadfixuser.Model.OTPVerificationModel.OtpVerificationResponse;
import com.app.gadfixuser.Model.RegistrationModel.RegistrationResponse;

public class AppListener {
    public interface OnRegistrationListener{
        void onSuccess(RegistrationResponse registrationResponse);
        void onFailure(String message);
    }

    public interface  OnOtpVerificationListener{
        void onSuccess(OtpVerificationResponse otpVerificationResponse);
        void onFailure(String message);
    }

    public interface  OnLoginListener{
        void onSuccess(LoginResponse loginResponse);
        void onFailure(String message);
    }
}
