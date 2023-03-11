package com.example.m4l7_mvvmroom.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {EmployeeEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

   public abstract EmployeeDao employeeDao();
}