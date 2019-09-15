package com.acampdev.busstop;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.acampdev.busstop.Helpers.DBHelper;
import com.acampdev.busstop.Models.User;

public class Data{
    Context context;
    SQLiteDatabase database;
    SQLiteOpenHelper openHelper;

    public Data(Context context){
        this.context = context;
        openHelper = new DBHelper(context);
        database=openHelper.getWritableDatabase();
    }

    public void open(){
        database=openHelper.getWritableDatabase();
    }
    public void close(){
        openHelper.close();
    }

    public long  getItemsCounts(){
        return DatabaseUtils.queryNumEntries(database,SQLConstants.UserTable);
    }

    public void insertUser(User user){
        ContentValues contentValues = user.toValues();
        database.insert(SQLConstants.UserTable,null,contentValues);
        database.close();
    }

}
