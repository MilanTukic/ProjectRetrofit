package com.example.tukic.projectretrofit.service;

/**
 * Created by Tukic on 6/13/2017.
 */

public class ApiUtils {

    private ApiUtils() {}
    public static final String BASE_URL = "http://192.168.1.251:96/api/students/";
    public static Client getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(Client.class);
    }
}
