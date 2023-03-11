package com.example.m4l7_mvvmroom.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "employees")
public class EmployeeEntity implements Serializable {
    public EmployeeEntity(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "salary")
    public Integer salary;

}
