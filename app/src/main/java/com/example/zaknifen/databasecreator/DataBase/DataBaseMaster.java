package com.example.zaknifen.databasecreator.DataBase;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.zaknifen.databasecreator.models.User;

import java.util.ArrayList;
import java.util.List;

import static com.example.zaknifen.databasecreator.DataBase.DataBaseCreator.*;
import static com.example.zaknifen.databasecreator.DataBase.DataBaseCreator.UserColumns.*;


public class DataBaseMaster {
    private SQLiteDatabase database;
    private DataBaseCreator dbCreator;

    private static DataBaseMaster instance;

    private DataBaseMaster(Context context) {
        dbCreator = new DataBaseCreator(context);
        if (database == null && !database.isOpen()) {
            database = dbCreator.getWritableDatabase();
        }
    }

    public static DataBaseMaster getInstance(Context context) {
        if (instance == null) {
            instance = new DataBaseMaster(context);
        }
        return instance;

    }
    public void addUser(User user){
        ContentValues cv = new ContentValues();
        cv.put(NAME, user.name);
        long id = database.insert(TABLE_NAME, null, cv);
        Log.d("addUser", String.valueOf(id));
    }
    public List<User> getAllUsersRaw() {
        String query = "SELECT " + NAME + " FROM " + TABLE_NAME;
        Log.d("getAllUsers", "query: " + query);
        Cursor cursor = database.rawQuery(query, null);

        List<User> list = new ArrayList<>();

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            User user = new User();
            user.name = cursor.getString(cursor.getColumnIndex(NAME));
            Log.d("getAllUsers", "name: " + user.name);
            list.add(user);
            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }


    public List<User> getAllUsersQuery(){

        Cursor cursor =database.query(TABLE_NAME, new String[]{NAME}, null, null, null, null, null);
        List<User> list = new ArrayList<>();

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            User user = new User();
            user.name = cursor.getString(cursor.getColumnIndex(NAME));
            Log.d("getAllUsers", "name: " + user.name);
            list.add(user);
            cursor.moveToNext();
            Log.d("yad", "getUsers");
        }
        cursor.close();
        return list;


    }

}

