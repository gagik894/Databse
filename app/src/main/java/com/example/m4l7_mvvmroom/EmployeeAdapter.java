package com.example.m4l7_mvvmroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.m4l7_mvvmroom.database.EmployeeEntity;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeCardHolder> {
    List<EmployeeEntity> employeeEntities;

    public void setEmployeeEntities(List<EmployeeEntity> employeeEntities) {
        this.employeeEntities = new ArrayList<>(employeeEntities);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeeCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        return new EmployeeCardHolder(inflater.inflate(R.layout.employee_card, parent, false));
    }

    @NonNull

    @Override
    public void onBindViewHolder(@NonNull EmployeeCardHolder holder, int position) {
        holder.tvId.setText(String.valueOf(employeeEntities.get(position).id));
        holder.tvName.setText(String.valueOf(employeeEntities.get(position).name));
        holder.tvSalary.setText(String.valueOf(employeeEntities.get(position).salary));
    }

    @Override
    public int getItemCount() {
        return employeeEntities != null ? employeeEntities.size() : 0;
    }

    public class EmployeeCardHolder extends RecyclerView.ViewHolder{
        TextView tvId;
        TextView tvName;
        TextView tvSalary;

        public EmployeeCardHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);
            tvSalary = itemView.findViewById(R.id.tvSalary);

        }
    }
}
