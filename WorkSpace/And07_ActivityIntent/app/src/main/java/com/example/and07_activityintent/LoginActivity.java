package com.example.and07_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    EditText id, pw;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id = findViewById(R.id.id);
        pw = findViewById(R.id.pw);
        btn = findViewById(R.id.btn);

        // editText에 있는 글자를 가져오늘 메소드 : editText.getText() 입니다 ※ getText메소드가 리턴해주는 타입을 뭘까?

        Log.d("송빛나", id.getText().toString());

        btn.setOnClickListener(new View.OnClickListener() { // 인터페이스를 new로 생성하면 메소드가 반드시 있어야해서 익명의 클래스 지역을 만든다.
            @Override
            public void onClick(View v) {
                //Intent를 이용하면 화면 전환 -> Intent객체 (안드로이드의 4대 컴포넌트의 통신을 담당) Act => 'Intent' => Act
                //Context(맥락, 상태정보 확인) ? : 현재 화면에 떠있는 객체인지 ?
                //ex) DAO, DTO, VO => 화면에 떠있는 객체가 아니기 때문에 그래픽 작업을 하면 오류가 발생함 => 일반 클래스
                //ex) ↑ Act, Fragment => 화면에 떠있는 객체이기 때문에 그래픽 작업을 할 수 있음. 하지만 화면에 떠있는지의 상태를 알려줄 수 있는게 필요함 =>Context
                //=> 일반클래스에서도 그래픽처리가 가능하게 만드려면 Activity가 Context라는 것을 파라메터로 보내줬을 때. 가능함.
                if("admin".equals(id.getText().toString())&&"admin1234".equals(pw.getText().toString())) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("strkey", id.getText().toString()+"intent");
                    // intkey 숫자를 다음액티비티로 전송해보기 ( int )
                    intent.putExtra("intkey", 564);

                    LoginDTO dto = new LoginDTO(id.getText().toString()+"1", pw.getText().toString()+"1");
                    intent.putExtra("dtokey", dto);


                    ArrayList<LoginDTO> list = new ArrayList<>(); // 초기화식 LoginDTO타입을 묶어놓을 공간 마련
                    list.add(new LoginDTO("아이디1", "비밀번호1"));
                    list.add(new LoginDTO("아이디2", "비밀번호2"));
                    list.add(new LoginDTO("아이디3", "비밀번호3"));
                    list.add(new LoginDTO("아이디4", "비밀번호4"));
                    list.add(new LoginDTO("아이디5", "비밀번호5"));

                    intent.putExtra("list", list); //startActivity메소드 실행 전 데이터 담는 처리를 끝낸다.

                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "아이디, 비밀번호 틀림", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public class SbnClass implements Serializable {

    }

    public void method(Serializable s) {
        // 역직렬화 : SbnClass s2 = (SbnClass) s;
    }

}