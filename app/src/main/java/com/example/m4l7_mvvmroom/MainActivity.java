package com.example.m4l7_mvvmroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EmployeeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rvMain);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        adapter = new EmployeeAdapter();
        recyclerView.setAdapter(adapter);

        EmployeeViewModel employeeViewModel = new EmployeeViewModel(getApplication());
        employeeViewModel.getEmployees().observe(this, employeeEntities ->
                adapter.setEmployeeEntities(employeeEntities));
        EditText etName = findViewById(R.id.etName);
        EditText etSalary = findViewById(R.id.etSalary);
        Button addButton = findViewById(R.id.btnSubmit);

        addButton.setOnClickListener(view->{
            employeeViewModel.addEmployees(etName.getText().toString(), Integer.parseInt(etSalary.getText().toString()));
        });
        employeeViewModel.readEmployees();
    }
}