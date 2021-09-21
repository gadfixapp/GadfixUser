package com.app.gadfixuser.Network;

public class NetworkConfig {

    private static String _ENV  = "DEV"; // DEV / PRODUCTION

    public static String GET_BASE_URL(){
        if(_ENV.equals("PRODUCTION"))
            return _BASE_URL_PROD;
        else
            return _BASE_URL_DEV;
    }

    //Production Url
    public static String _BASE_URL_PROD="https://gadfix.com/demo/gadfix/CustumerApi/";
    //Development Url
    public static String _BASE_URL_DEV="https://gadfix.com/demo/gadfix/CustumerApi/";



}
