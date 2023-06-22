package com.example.and09_fragmentadapter.grid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.and09_fragmentadapter.R;

import java.util.ArrayList;

public class AdapterGridview extends BaseAdapter {

    LayoutInflater inflater;

    public AdapterGridview(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        v = inflater.inflate(R.layout.item_gridv, parent, false);
        ImageView imgv_profile = v.findViewById(R.id.imgv_profile);
        imgv_profile.setImageResource(R.drawable.img1);
        TextView tv_name = v.findViewById(R.id.tv_name);
        tv_name.setText("고슴도치");

        return v;
    }

    // 뷰홀더라는 것을 강제한다. (위젯을 한 번 찾거나 이미 붙여진 칸의 경우에는 처음부터 디자인 작업을 다시 하는 게 아니라)
    // 이미 붙어진 것을 "재활용"한다.
    public class ViewHolder{//위젯용 DTO
        // item_listview에 있는 모든 위젯을 찾아서 넣어둠. (초기화)
        ImageView imgv;
        TextView tv_name;
        View v;

        public ViewHolder(View v) {
            this.v = v;
            imgv = v.findViewById(R.id.imgv_profile);
            tv_name = v.findViewById(R.id.tv_name);
        }
    }
}
