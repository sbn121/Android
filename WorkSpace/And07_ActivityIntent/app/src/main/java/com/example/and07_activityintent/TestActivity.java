package com.example.and07_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent intent = getIntent();

        String str = intent.getStringExtra("str");
        Log.d("인텐트", "onCreate: "+str);

        int i = intent.getIntExtra("int", -1);
        Log.d("인텐트", "onCreate: "+i);

        TestDTO dto = (TestDTO) intent.getSerializableExtra("dto");
        Log.d("인텐트", "onCreate: "+dto.getStr()+dto.getI());

        ArrayList<TestDTO> list = (ArrayList<TestDTO>) intent.getSerializableExtra("list");
        Log.d("인텐트", "onCreate: "+list.get(0).getStr()+list.get(0).getI());

    }

}