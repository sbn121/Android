package com.example.and00_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.and00_login.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(v -> {
            CommonConn conn = new CommonConn(this, "member/login");
            conn.addParamMap("id", binding.edtId.getText().toString());
            conn.addParamMap("pw", binding.edtPw.getText().toString());
            conn.onExcute((isResult, data) -> {
                Log.d("결과 : ", "onCreate: ↑ "+data);
            }); // onExcute로 메소드가 실행되면 일단 Spring으로 전송처리는 정상적으로 작돋
    });
    }

    //올바른 방법 아니어서 확인하고 지움
//    public static void test(String data){
//        Log.d("결과  : ", "test: "+data);
//    }


}