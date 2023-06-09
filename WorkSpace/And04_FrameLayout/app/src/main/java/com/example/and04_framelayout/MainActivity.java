package com.example.and04_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_change1, btn_change2;
    //ImageView imgv1, imgv2, imgv3;
    ArrayList<ImageView> imgList = new ArrayList<>();

    int flag=0;
    // 현재 객체를 선언만 해둔 상태에서는 4개의 객체 모두 null인 상태이다.
    // null
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //res하위에 있는 모든 것들은 "R"이라는 클래스로 하나로 묶인다.
        btn_change1 = findViewById(R.id.btn_change1);
        btn_change2 = findViewById(R.id.btn_change2);
        //ArrayList<E> list.add(E);
        imgList.add(findViewById(R.id.imgv1));
        imgList.add(findViewById(R.id.imgv2));
        imgList.add(findViewById(R.id.imgv3));


        //버튼의 클릭을 감지하는 메소드 . 인터페이스 View.OnClickListener<-
        // 1. 직접 인터페이스를 인스턴스화하여 파라메터로 넘기는 방법
//        View.OnClickListener sbnOnclick = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("버튼", "버튼이 눌림");
//            }
//        };
        // 2. 인터페이스를 초기화할 수 있는 new 생성자로 파라메터를 넘기는 방법
        btn_change1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("버튼", "버튼이 눌림 new");
            }
        });


//        btn_change.setOnClickListener(new SbnEvent());

//        onClick(btn_change);

        // 4. 자바의 인터페이스 단점을 보완 -> lamda (람다식, 함수형으로 new나 불필요한 코드를 생략하고 사용하는 방법)
        // 인터페이스의 abstract메소드가 1개의 경우만 사용가능. (인터페이스의 내부 구조를 모르면 사용이 거의 불가능함, 초보자)
//        btn_change.setOnClickListener(v -> { // 인터페이스가 주는 파라메터를 (v)써주고 메소드지역을 -> 가리킴 { }
//
//        });

//        btn_change1.setOnClickListener(this); // 내부적으로 가지고 있는 interface가 setter에 의해서 초기화됨.
//        btn_change2.setOnClickListener(this::onClick2);


        btn_change1.setOnClickListener(v -> { // 내부적으로 가지고있는 interface가 setter에 의해서 초기화됨.
            flag--;
            if(flag==-1) {
                flag=2;
            }
            Log.d("로그", "변수 Flag : "+flag);
            changeImage();
        });

        btn_change2.setOnClickListener(v -> { // 내부적으로 가지고있는 interface가 setter에 의해서 초기화됨.
            flag++;
            if(flag==imgList.size()) {
                flag=0;
            }
            Log.d("로그", "변수 Flag : "+flag);
            changeImage();
        });
    }

    // 3. 인터페이스를 상속받는 방법
    // -> Spring MVC의 경우에는 DAO 또는 Service가 반드시 구현해야만 하는 메소드의 형태를 만들어서 설계도 개념으로 사용. (많은 개발자가 협업시 편리한 방법)
    // -> Android <- 다형성을 이용한 방법 : View.OnClickListener <= onClick이라는 메소드를 반드시 가지고 있음.
    //                                      View.OnClickListener라는 것을 상속받은 Class는 ==ViewOnClickListener와 같다가 성림.

//    public class SbnEvent implements View.OnClickListener {
//
//        @Override
//        public void onClick(View v) {
//            Log.d("버튼", "SbnEvent 상속받아서 버튼 눌림을 감지");
//        }
//    }

    // java코드를 이용하여 이미지 바꾸기 클릭시


    public void changeImage(){
        for(int i=0; i<imgList.size(); i++) {
            imgList.get(i).setVisibility(View.GONE);
        }
        imgList.get(flag).setVisibility(View.VISIBLE);
    }



    @Override
    public void onClick(View v) {

        flag++;
//        if(flag>=3) {
//            flag=0;
//        }
//        ImageView[] str = {imgv1, imgv2, imgv3};
//        int j = flag%3;
//        Log.d("버튼", "flag : "+flag+" j : "+j);
//        str[j%3].setVisibility(View.VISIBLE);
//        str[(j+1)%3].setVisibility(View.GONE);
//        str[(j+2)%3].setVisibility(View.GONE);
    }
//    public void onClick2(View v) {
//        i--;
//        if(i<=0) {
//            i=3;
//        }
//        ImageView[] str = {imgv1, imgv2, imgv3};
//        int j = i%3;
//        Log.d("버튼", "i : "+i+" j : "+j);
//        str[j%3].setVisibility(View.GONE);
//        str[(j+1)%3].setVisibility(View.GONE);
//        str[(j+2)%3].setVisibility(View.VISIBLE);
//
//    }

}