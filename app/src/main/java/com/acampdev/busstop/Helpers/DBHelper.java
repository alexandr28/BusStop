package com.acampdev.busstop.Helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.acampdev.busstop.Models.User;
import com.acampdev.busstop.SQLConstants;

public class DBHelper  extends SQLiteOpenHelper {
    SQLiteDatabase sqLiteDatabase;
    public static final int DB_VERSION=1;
    public DBHelper(Context context){
        super(context, SQLConstants.DB,null,DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLConstants.SQL_CREATE__TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQLConstants.SQL_DELTE);
        onCreate(db);
    }

    public void addUser(User user){

        sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=user.toValues();
        sqLiteDatabase.insert(SQLConstants.UserTable,null,contentValues);
        sqLiteDatabase.close();
    }

    public boolean checkUser(String email,String password){
        String[] columns={SQLConstants.COLUMN_ID};
        sqLiteDatabase = getReadableDatabase();
        String selection = SQLConstants.COLUMN_EMAIL + "= ? "+" AND "+ SQLConstants.COLUMN_PASSWORD+ "= ?";
        String[] selectionArgs={email,password};
        Cursor cursor= sqLiteDatabase.query(SQLConstants.UserTable,columns,selection,selectionArgs,null,null,null);
        int cursorCount= cursor.getCount();
        cursor.close();
        sqLiteDatabase.close();
        if(cursorCount>0){
            return true;
        }else{
            return  false;
        }
    }
}
