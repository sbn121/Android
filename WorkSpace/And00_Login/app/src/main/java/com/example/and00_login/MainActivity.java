package com.example.and00_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.and00_login.databinding.ActivityMainBinding;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    // 메소드 -> 리턴타입이 있는 메소드를 구현, 호출을 자유롭게 하고 사용하는 이유를 명확히 알고있다.
    // 클래스 -> 클래스 내부에 있는 멤버의 접근과 각각의 멤버를 구분하고 자유롭게 커스텀할 수 있다.(변형)
    // 인터페이스 -> 인터페이스의 규칙을 명확히 알고 자유롭게 구현하여 사용할 수 있다.


    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        CommonConn.SbnCallBack callBack = new CommonConn.SbnCallBack() {
            @Override
            public void onResult(boolean isResult, String data) {
                Log.d("결과", "onResult: "+data);
            }
        };//<-@메모리번지수를 참조하는 인터페이스를 초기화함 (내부에는 메소드가 반드시있음.)
        Log.d("콜백", "콜백(인터페이스의 메모리):"+callBack);
        TestVO vo = new TestVO();//메모리 번지수에 TestVO를 올림 @20374
        vo.str = "111";//@20374 내부의 str변수를 "111"로 값을 할당함.
        testMethod(vo);// <-@20374
        Log.d("aaa", "onCreate: "+vo.str);//<-@20374는 "222"

        callBack.onResult(true, "값을 넘김"); //외부에서 이 코드를 쓸 수 있게 해줌.


        binding.btnLogin.setOnClickListener(v -> {
            CommonConn conn = new CommonConn(this, "member/login");
            conn.addParamMap("id", binding.edtId.getText().toString());
            conn.addParamMap("pw", binding.edtPw.getText().toString());
            conn.onExcute(callBack); // onExcute로 메소드가 실행되면 일단 Spring으로 전송처리는 정상적으로 작동
    });
    }

    public class TestVO{
        String str;
    }
    public void testMethod(TestVO vo){
        vo.str="222";//<=20374 내부의 str변수를 "222"로 값 재할당
    }


}