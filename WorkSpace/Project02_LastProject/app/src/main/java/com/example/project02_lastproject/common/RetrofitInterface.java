package com.example.project02_lastproject.common;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface RetrofitInterface {

        //get + querymap
        //post + fieldmap

        @GET("{url}")
        Call<String> getLogin(@Url String url, @QueryMap HashMap<String, Object> paramMap);

        @FormUrlEncoded
        @POST
        Call<String> postLogin(@Url String url, @FieldMap HashMap<String, Object> paramMap);


}
