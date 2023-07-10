package com.example.and00_springtoand;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import java.util.HashMap;

public class CommonConn {

    private Context context;
    private String mapping;
    private HashMap<String, Object> paramMap;
    private ProgressDialog dialog;

    public CommonConn(Context context, String mapping) {
        this.context = context;
        this.mapping = mapping;
        this.paramMap = new HashMap<>();
    }

    public void addParamMap(String key, Object value){
        if(key==null){
            Log.e("TAG", "addParamMap: 뿡");

        }else if (value==null){
            Log.e("TAG", "addParamMap: 뿡");
        }else {
            paramMap.put(key, value);
        }
    }



}
