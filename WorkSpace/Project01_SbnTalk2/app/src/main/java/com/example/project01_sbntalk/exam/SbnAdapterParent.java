package com.example.project01_sbntalk.exam;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SbnAdapterParent {

    public abstract static class SbnAdapter<SVH extends SbnViewHolder>{
        public abstract SVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType);
        public abstract void onBindViewHolder();
        public abstract int getItemCount();
    }

    public abstract static class SbnViewHolder{
        // 디자인 파일을 묶어놓은 객체 ===> View
        @NonNull
        final View view; // 상수의 규칙 (1. 상수를 선언과 동시에 값할당==> 초기화해놓는방법)
                         //              2. 생성자를 이용해서 초기화하는 방법

        public SbnViewHolder(@NonNull View view) {
            this.view = view;
        }
    }
}
