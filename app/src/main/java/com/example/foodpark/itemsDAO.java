package com.example.foodpark;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface itemsDAO {
        @Insert
        void insertitems(Items items);

        @Query("SELECT EXISTS(SELECT * FROM items WHERE pid = :productid)")
        Boolean is_exist(int productid);


        @Query("SELECT * FROM Items")
        List<Items> getallitems();

        @Query("DELETE FROM Items WHERE pid = :id")
        void deleteById(int id);
    }

