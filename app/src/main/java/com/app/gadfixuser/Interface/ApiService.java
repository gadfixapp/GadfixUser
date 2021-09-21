package com.app.gadfixuser.Interface;


import com.app.gadfixuser.Model.LoginModel.LoginRequest;
import com.app.gadfixuser.Model.LoginModel.LoginResponse;
import com.app.gadfixuser.Model.OTPVerificationModel.OtpVerificationRequest;
import com.app.gadfixuser.Model.OTPVerificationModel.OtpVerificationResponse;
import com.app.gadfixuser.Model.RegistrationModel.RegistrationRequest;
import com.app.gadfixuser.Model.RegistrationModel.RegistrationResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {

    @POST("registration")
    Call<RegistrationResponse> getRegister(@Body RegistrationRequest registrationRequest);

    @POST("verify_otp")
    Call<OtpVerificationResponse> getOTP(@Body OtpVerificationRequest otpVerificationRequest);

    @POST("login")
    Call<LoginResponse> getLogin(@Body LoginRequest loginRequest);


    }



