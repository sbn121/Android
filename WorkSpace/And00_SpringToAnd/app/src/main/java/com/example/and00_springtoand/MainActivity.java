package com.example.and00_springtoand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RetrofitClient rc = new RetrofitClient();
        RetrofitInterface api = rc.getRetrofit().create(RetrofitInterface.class);
        api.getCuList().enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String result = response.body();
                //TypeToken : 버그가 았음 new TypeToken을 바로 메소드에 넣으면 가끔 안나옴.
                //그럴때는 아무데나 가서 TypeToken글자를 쳐줌 <= List형태로 바꿀 때 사용함
                ArrayList<MiddleVO> list = new Gson().fromJson(
                        result, new TypeToken<ArrayList<MiddleVO>>(){}.getType()
                );
                Log.d("레트로핏", "onResponse: "+list.size());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}