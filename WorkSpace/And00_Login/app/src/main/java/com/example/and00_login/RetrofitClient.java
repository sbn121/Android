package com.example.and00_login;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {

//    Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl("https://api.github.com/")
//            .build();
//
//    GitHubService service = retrofit.create(GitHubService.class);

    public Retrofit retrofitLogin(){
        return new Retrofit.Builder()
                .baseUrl("http://192.168.0.33:8080/middle/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

}
