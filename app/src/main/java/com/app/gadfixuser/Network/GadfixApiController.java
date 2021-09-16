package com.app.gadfixuser.Network;

import android.content.Context;


import com.app.gadfixuser.Interface.ApiService;
import com.app.gadfixuser.Preference.UserSharedpreference;

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

}
