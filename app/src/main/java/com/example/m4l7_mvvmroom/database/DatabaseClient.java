package com.example.m4l7_mvvmroom.database;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {
    public static final String DB_NAME = "room.db";
    private static DatabaseClient instance;
    private final AppDatabase appDatabase;

    private DatabaseClient(Context context){
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
    }

    public static synchronized DatabaseClient getInstance(Context context){
        if (instance == null){
            instance = new DatabaseClient(context);
        }
        return instance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
