package com.example.foodpark;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Items.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract itemsDAO iteamDAO();
    }

