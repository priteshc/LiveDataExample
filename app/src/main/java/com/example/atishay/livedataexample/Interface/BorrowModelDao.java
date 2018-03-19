package com.example.atishay.livedataexample.Interface;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.Update;

import com.example.atishay.livedataexample.dataconverter.DateConverter;
import com.example.atishay.livedataexample.model.BorrowModel;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by Atishay on 19-03-2018.
 */

@Dao
@TypeConverters(DateConverter.class)
public interface BorrowModelDao {

    @Query("select * from BorrowModel")
    LiveData<List<BorrowModel>> getAllBorrowedItems();

    @Query("select * from BorrowModel where id = :id")
    BorrowModel getItembyId(String id);

    @Insert(onConflict = REPLACE)
    void addBorrow(BorrowModel borrowModel);

    @Delete
    void deleteBorrow(BorrowModel borrowModel);

    @Query("update  BorrowModel set itemName= :name where id = :id")
    BorrowModel getupdate(String id,BorrowModel borrowModel);






}