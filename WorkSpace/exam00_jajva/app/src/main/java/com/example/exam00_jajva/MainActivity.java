package com.example.exam00_jajva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    Button btn1, btn_start, btn_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSum(1, 2);//메소드가 구현(정의)되어있는 파라메터부 = 호출부의 파라메터 값을 합치면 변수 초기화식이 된다.
        // int num1 = 1, int num = 2 ↑
        tv1 = findViewById(R.id.tv1);
        btn1 = findViewById(R.id.btn1);
        btn_start = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);
        CalDAO dao = new CalDAO();



        dao.num1 = 1;
        dao.num2 = 1;
        //dao.num3 = 1; private으로 외부에서 접근을 x
        dao.num4 = 2;
        CalDAO.num5 = 5;
        //CalDAO.num6 = 6; //private으로 막아져있음.
        CalDAO.num7 = 7;

        CalDAO.ChildClass childClass = dao.new ChildClass();
        childClass.fieldChild = 1;

        CalDAO.StaticChildClass staticChildClass = new CalDAO.StaticChildClass();
        staticChildClass.fieldChild1=1;
//        dao.getSum(1, 2, tv1);
//        dao.getSum(1, 2, btn1);
//        btn1.setText(tv1.getText().toString());
//        tv1.setText(dao.getSum(1, 2)+"");
//        btn1.setText(dao.getSum(1, 2)+"");
//        tv1.setText(""+getSum(1, 2));
        SbnOnClick on = new SbnOnClick();
        btn_start.setOnClickListener(on);

        on.onClick(btn_start);

        SbnCallback callback = new SbnCallback() {
            @Override
            public void onResponse(String data) {
                Log.d("성공", "onResponse: ");
            }

            @Override
            public void onFailure(String data) {
                Log.d("실패", "onFailure: ");
            }
        };

        callback.onResponse("성공");
        callback.onFailure("실패");
    }

    // 메소드는 구현이 자유롭다.
    // 실행은 항상 사용하는 곳에서 호출을 해줘야지만 됨.

    public interface SbnCallback{
        public void onResponse(String data);
        public void onFailure(String data);
    }

    public class SbnOnClick implements View.OnClickListener{//View.OnClickListener는 onClick이라는 메소드가 반드시 구현되어야하는 규칙이있다.
                                                            //(인터페이스)상속을 받게되면 onClick이라는 메소드가 반드시 구현되기 때문에 둘은 같다라는
                                                            //규칙이 성립이 된다.
        @Override
        public void onClick(View v) {
            Log.d("온클릭", "onClick: ");
        }
    }

}