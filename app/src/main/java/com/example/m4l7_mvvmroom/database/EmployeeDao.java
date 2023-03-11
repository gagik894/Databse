package com.example.m4l7_mvvmroom.database;

import  androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EmployeeDao {
    @Query("Select * From employees")
    List<EmployeeEntity> getAll();
    @Insert
    long insertEmployee(EmployeeEntity employeeEntity);
}
