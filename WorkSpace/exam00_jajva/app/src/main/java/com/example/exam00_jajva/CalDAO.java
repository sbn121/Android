package com.example.exam00_jajva;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

//계산용 DAO
public class CalDAO {
    // 클래스의 멤버는 크게 두 가지가 있다.
    // 왜 멤버를 나눠서 사용을 할까???
    // ->
    // 인스턴스 멤버, 스태틱 멤버
    int num1, num2; // 인
    private int num3;//인
    public int num4; //인

    static int num5; //스
    private static int num6;//스
    public static int num7;//스

    //void타입은 return이 없는 메소드임. 결과를 받을 수가 없다(외부)
    public int getSum(int num1, int num2){
        return num1+num2;
    }

    public static  int getSum(){
        return 0;
    }

    public class ChildClass{
        int fieldChild;
    }
    public static class StaticChildClass{
        int fieldChild1;
    }

    //지역변수 (메소드 내부에서 선언된어 사용되는 변수)
    public int method(){
        //지역화폐
        //외부에서 절대로 접근이 불가능하다. ==> return
        int num1 = 0; //지역변수
        return num1;
    }

//    public void getSum(int num1, int num2, TextView tv1) {
//        Log.d("두 수의 합(텍스트뷰)", "getSum: " + (num1 + num2));
//        tv1.setText("" + (num1 + num2));
//    }
//
//    public void getSum(int num1, int num2, Button btn1) {
//        Log.d("두 수의 합(버튼)", "getSum: " + (num1 + num2));
//        btn1.setText("" + (num1 + num2));
//    }

}
