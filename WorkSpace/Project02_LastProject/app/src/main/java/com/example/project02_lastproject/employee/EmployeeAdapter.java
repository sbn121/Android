package com.example.project02_lastproject.employee;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_lastproject.R;
import com.example.project02_lastproject.databinding.ItemRecvEmployeesBinding;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder>{

    List<EmployeeVO> list;

    Context context;

    public EmployeeAdapter(List<EmployeeVO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewHolder(ItemRecvEmployeesBinding.inflate(LayoutInflater.from(context), parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        if(list.get(i).get담당업무().contains("President")){
            h.binding.ln.setBackgroundResource(R.drawable.border_radius);
        }else if(list.get(i).get담당업무().contains("Manager")){
            h.binding.ln.setBackgroundResource(R.drawable.border_radius2);
        }else if(list.get(i).get담당업무().contains("Clerk")){
            h.binding.ln.setBackgroundResource(R.drawable.border_radius3);
        }else if(list.get(i).get담당업무().contains("Representative")){
            h.binding.ln.setBackgroundResource(R.drawable.border_radius4);
        }else{
            h.binding.ln.setBackgroundResource(R.drawable.border_radius5);
        }
        h.binding.tvName.setText(list.get(i).get이름());
        h.binding.tvId.setText("("+list.get(i).get사번()+")");
        h.binding.tvEmail.setText(list.get(i).get이메일());
        h.binding.tvSalary.setText(list.get(i).get급여()+"");
        if(list.get(i).get급여().contains("(")){
            h.binding.imgvSalary.setImageResource(R.drawable.ic_launcher_foreground2);
        }else {
            h.binding.imgvSalary.setImageResource(R.drawable.ic_launcher_foreground);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ItemRecvEmployeesBinding binding;

        public ViewHolder(@NonNull ItemRecvEmployeesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
