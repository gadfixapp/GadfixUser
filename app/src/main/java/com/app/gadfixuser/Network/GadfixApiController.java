package com.app.gadfixuser.Network;

import android.content.Context;


import com.app.gadfixuser.Interface.ApiService;
import com.app.gadfixuser.Listener.AppListener;
import com.app.gadfixuser.Model.LoginModel.LoginRequest;
import com.app.gadfixuser.Model.LoginModel.LoginResponse;
import com.app.gadfixuser.Model.OTPVerificationModel.OtpVerificationRequest;
import com.app.gadfixuser.Model.OTPVerificationModel.OtpVerificationResponse;
import com.app.gadfixuser.Model.RegistrationModel.RegistrationRequest;
import com.app.gadfixuser.Model.RegistrationModel.RegistrationResponse;
import com.app.gadfixuser.Preference.UserSharedpreference;
import com.app.gadfixuser.Utils.OtherConfig;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GadfixApiController {
    private Context context;
    private ApiService apiService;
    private UserSharedpreference userSharedpreference;

    public GadfixApiController(Context context) {
        this.context = context;
        apiService = RetrofitClient.getInterface();
        userSharedpreference = UserSharedpreference.getInstance(context);
    }

    public void getRegistration(RegistrationRequest registrationRequest, final AppListener.OnRegistrationListener onRegistrationListener){
        apiService.getRegister(registrationRequest)
                .enqueue(new Callback<RegistrationResponse>() {
                    @Override
                    public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                        if (response.isSuccessful()){
                            if (response.body().getResponseCode() == 200){
                                onRegistrationListener.onSuccess(response.body());
                            }else {
                                onRegistrationListener.onFailure(response.body().getMessage());
                            }
                        }else {
                            onRegistrationListener.onFailure(OtherConfig.ERROR_MESSAGE);
                        }
                    }

                    @Override
                    public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                        onRegistrationListener.onFailure(t.getMessage());
                    }
                });
    }

    public  void getOtpVerification(OtpVerificationRequest otpVerificationRequest, final AppListener.OnOtpVerificationListener onOtpVerificationListener){
        apiService.getOTP(otpVerificationRequest)
                .enqueue(new Callback<OtpVerificationResponse>() {
                    @Override
                    public void onResponse(Call<OtpVerificationResponse> call, Response<OtpVerificationResponse> response) {
                        if(response.isSuccessful()){
                            if(response.body().getResponseCode()==200){
                                onOtpVerificationListener.onSuccess(response.body());
                            }
                            else{
                                onOtpVerificationListener.onFailure(response.body().getMessage());
                            }
                        }
                        else{
                            onOtpVerificationListener.onFailure(OtherConfig.ERROR_MESSAGE);
                        }
                    }

                    @Override
                    public void onFailure(Call<OtpVerificationResponse> call, Throwable t) {
                        onOtpVerificationListener.onFailure(t.getMessage());
                    }
                });
    }

    public  void getLogin(LoginRequest loginRequest, final AppListener.OnLoginListener onLoginListener){
        apiService.getLogin(loginRequest)
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if(response.isSuccessful()){
                            if(response.body().getResponseCode()==200){
                                onLoginListener.onSuccess(response.body());
                            }
                            else{
                                onLoginListener.onFailure(response.body().getMessage());
                            }
                        }else{
                            onLoginListener.onFailure(OtherConfig.ERROR_MESSAGE);
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        onLoginListener.onFailure(t.getMessage());
                    }
                });
    }

}
