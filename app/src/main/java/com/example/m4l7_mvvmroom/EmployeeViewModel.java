package com.example.m4l7_mvvmroom;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.m4l7_mvvmroom.database.AppDatabase;
import com.example.m4l7_mvvmroom.database.DatabaseClient;
import com.example.m4l7_mvvmroom.database.EmployeeEntity;

import java.util.List;

public class EmployeeViewModel extends AndroidViewModel {
    private MutableLiveData<List<EmployeeEntity>> employees;
    private AppDatabase appDatabase;
    public EmployeeViewModel(@NonNull Application application) {
        super(application);
        employees = new MutableLiveData<>();
        appDatabase = DatabaseClient.getInstance(getApplication()).getAppDatabase();
    }
    public LiveData<List<EmployeeEntity>> getEmployees() {return employees;}
    public void addEmployees(String name, Integer salary){
        AsyncTask.execute(()->{
            appDatabase.employeeDao().insertEmployee(new EmployeeEntity(name,salary));
            List<EmployeeEntity> updateList = appDatabase.employeeDao().getAll();
            employees.postValue(updateList);
        });
    }

    public void readEmployees(){
        AsyncTask.execute(()->{
            List<EmployeeEntity> currentList = appDatabase.employeeDao().getAll();
            employees.postValue(currentList);
        });
    }
}
