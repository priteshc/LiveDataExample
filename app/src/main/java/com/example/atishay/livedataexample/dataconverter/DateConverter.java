package com.example.atishay.livedataexample.dataconverter;

/**
 * Created by Atishay on 19-03-2018.
 */

import android.arch.persistence.room.TypeConverter;

import java.util.Date;
public class DateConverter {

    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}