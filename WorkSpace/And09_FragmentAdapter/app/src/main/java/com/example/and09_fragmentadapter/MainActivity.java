package com.example.and09_fragmentadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    FrameLayout container;
    Button btn_menu1, btn_menu2, btn_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Fragment를 붙이기 위한 공간, Fragment, FragmentManager 3가지의 요소가 필요하다.

        btn_menu1 = findViewById(R.id.btn_menu1);
        btn_menu2 = findViewById(R.id.btn_menu2);
        btn_adapter = findViewById(R.id.btn_adapter);
//        container = findViewById(R.id.container); <= FragmentManager에서는 객체로 초기화된 위젯이 필요 x, 디자인파일에 있는 id만 명시해주면 O

        FragmentManager manager = getSupportFragmentManager(); //프래그먼트 매니저의 초기화식.

        btn_menu1.setOnClickListener(v -> {
            Log.d("버튼", "메뉴1");
            //트랜잭션 : Oracle 작업 최소 단위 <=> 세트 : Commit & Rollback
//            manager.beginTransaction().add(R.id.container, new HomeFragment(), "A").commit();
            manager.beginTransaction().replace(R.id.container, new HomeFragment()).commit();
        });
        btn_menu2.setOnClickListener(v -> {
            Log.d("버튼", "메뉴2");
            //manager.beginTransaction().remove
            manager.beginTransaction().replace(R.id.container, new SubFragment()).commit();
        });

        btn_adapter.setOnClickListener(v -> {
            Intent intent = new Intent(this, AdapterActivity.class);
            startActivity(intent);
        });

    }
}