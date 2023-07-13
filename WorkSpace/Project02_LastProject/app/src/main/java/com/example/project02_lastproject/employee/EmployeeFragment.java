package com.example.project02_lastproject.employee;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project02_lastproject.R;
import com.example.project02_lastproject.common.CommonConn;
import com.example.project02_lastproject.databinding.FragmentCustomerBinding;
import com.example.project02_lastproject.databinding.FragmentEmployeeBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class EmployeeFragment extends Fragment {

    FragmentEmployeeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEmployeeBinding.inflate(inflater, container, false);

        binding.swipeEmployee.setOnRefreshListener(() -> {
            CommonConn conn = new CommonConn(getContext(), "select");
            conn.onExcute((isResult, data) -> {
                List<EmployeeVO> list = new Gson().fromJson(data, new TypeToken<List<EmployeeVO>>(){}.getType());
                EmployeeAdapter adapter = new EmployeeAdapter(list, getContext());
                binding.recvEmployee.setAdapter(adapter);
                binding.recvEmployee.setLayoutManager(new LinearLayoutManager(getContext()));
            });
            binding.swipeEmployee.setRefreshing(false);
        });

        binding.sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                CommonConn conn = new CommonConn(getContext(), "search");
                conn.addParamMap("str", binding.sv.getQuery().toString());
                conn.onExcute((isResult, data) -> {
                    List<EmployeeVO> list = new Gson().fromJson(data, new TypeToken<List<EmployeeVO>>(){}.getType());
                    EmployeeAdapter adapter = new EmployeeAdapter(list, getContext());
                    binding.recvEmployee.setAdapter(adapter);
                    binding.recvEmployee.setLayoutManager(new LinearLayoutManager(getContext()));
                });
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        CommonConn conn = new CommonConn(getContext(), "select");
        conn.onExcute((isResult, data) -> {
            List<EmployeeVO> list = new Gson().fromJson(data, new TypeToken<List<EmployeeVO>>(){}.getType());
            EmployeeAdapter adapter = new EmployeeAdapter(list, getContext());
            binding.recvEmployee.setAdapter(adapter);
            binding.recvEmployee.setLayoutManager(new LinearLayoutManager(getContext()));
        });

        return binding.getRoot();
    }
}