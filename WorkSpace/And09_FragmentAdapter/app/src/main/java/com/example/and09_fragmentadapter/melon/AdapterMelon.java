package com.example.and09_fragmentadapter.melon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and09_fragmentadapter.R;

import java.util.ArrayList;

public class AdapterMelon extends RecyclerView.Adapter<AdapterMelon.MelonHolder>{

    LayoutInflater inflater;

    ArrayList<MelonDTO> list;


    public AdapterMelon(LayoutInflater inflater, ArrayList<MelonDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public MelonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recvmelon, parent, false);
        return new MelonHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MelonHolder holder, int i) {
        holder.imgv_album.setImageResource(list.get(i).getImgvRes());
        holder.tv_rank.setText(list.get(i).getRank()+"");
        holder.tv_title.setText(list.get(i).getTitle());
        holder.tv_artist.setText(list.get(i).getArtist());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MelonHolder extends RecyclerView.ViewHolder{

        ImageView imgv_album;

        TextView tv_rank, tv_title, tv_artist;

        public MelonHolder(@NonNull View v) {
            super(v);
            imgv_album = v.findViewById(R.id.imgv_album);
            tv_rank = v.findViewById(R.id.tv_rank);
            tv_title = v.findViewById(R.id.tv_title);
            tv_artist = v.findViewById(R.id.tv_artist);
        }
    }

}
