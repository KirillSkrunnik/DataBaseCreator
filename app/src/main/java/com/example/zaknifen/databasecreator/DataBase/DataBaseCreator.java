package com.example.zaknifen.databasecreator.DataBase;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DataBaseCreator extends SQLiteOpenHelper {
    public static final String  DB_NAME = "db_name";
    public static final int DB_VERSION = 1;


    public static class User implements BaseColumns{
        public static final String TABLE_NAME = "users";
        public static final String NAME  = "name";
    }

    static String CREATE_TABLE_USER = " CREATE_TABLE" + User.TABLE_NAME + " (" +
            User._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            User.NAME + " TEXT" + ");";

    public DataBaseCreator(Context context) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE_USER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
