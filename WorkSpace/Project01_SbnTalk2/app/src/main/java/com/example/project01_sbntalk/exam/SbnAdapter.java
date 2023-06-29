package com.example.project01_sbntalk.exam;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

public class SbnAdapter extends SbnAdapterParent.SbnAdapter<SbnAdapter.ViewHolder>{

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder() {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends SbnAdapterParent.SbnViewHolder{

        public ViewHolder(@NonNull View view) {
            super(view);
        }
    }
}
