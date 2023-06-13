package com.example.and06_resource;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Values/String 값 : ", R.string.sbn_version+""); //id(메모리번지수)
        Log.d("Values/String 값 : ", getString(R.string.sbn_version)); //실제 값 출력 ↑


    }
}