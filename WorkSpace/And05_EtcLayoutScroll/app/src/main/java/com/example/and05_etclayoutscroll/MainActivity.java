package com.example.and05_etclayoutscroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // static키워드가 있어서 초기화 과정 없이 사용가능 . SbnClass.ATTR
        // static키워드가 없어서 초기화를 시켜야만 사용 가능 .new SbnClass().append("초기화해야지 사용가능")

        TextView tv_text = findViewById(R.id.tv_text); // 내가 레이아웃(activity main)에 만든 위젯을 찾아서 java코드 변수로 초기화
        // TextView.TEXT_ALIGNMENT_GRAVITY // <= Static Member : 클래스가 인스턴스화 하지 않아도 메모리에 이미 올라가있는 멤버
        // tv_text.append(); // <= Member // <= Instance Member : 클래스가 인스턴스화 해야지만 메모리에 로딩되는 멤버
        tv_text.append("안녕하세요");

        Button btn_scroll = findViewById(R.id.btn_scroll);
        ScrollView scrollview = findViewById(R.id.scrollview);
        HorizontalScrollView horizontal_scroll = findViewById(R.id.horizon_scroll);

        // while(true) { <= 무한 반복하기 때문에 사용자가 눈으로 볼 수가 없음. (계속해서 append)
        // tv_text.append("안녕하세요")
        // }

        for(int i=0; i<50; i++) {
            for(int j=0; j<20; j++) {
                tv_text.append("안녕하세요");
            }
            tv_text.append("안녕하세요\n");
        }

        btn_scroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("스크롤 위치", "getScrollY : "+scrollview.getScrollY());
                scrollview.scrollTo(0, scrollview.getScrollY()+100);
                horizontal_scroll.smoothScrollTo(horizontal_scroll.getScrollX()+100, 0);
            }
        });











    }
}