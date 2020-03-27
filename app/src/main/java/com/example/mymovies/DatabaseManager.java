package com.example.mymovies;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager extends SQLiteOpenHelper {

    public DatabaseManager(Context context){
        super(context, "MoviesDB", null, 1);
    }

    public void onCreate(SQLiteDatabase db){
        String sql = "create table MovieTable (";
        sql += "id integer primary key autoincrement, ";
        sql += "title text, director text)";
        db.execSQL(sql);
    }

    public void insert(String movieName, String directorName){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "insert into MovieTable values(";
        sql += "null, '"+movieName+"', '"+directorName+"')";
        db.execSQL(sql);
        db.close();
    }

    public String[] get(){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select * from MovieTable";
        Cursor cursor = db.rawQuery(sql, null);
        String[] entry = new String[2];
        if (cursor.moveToFirst()){
            String title = cursor.getString(1);
            String director = cursor.getString(2);
            entry[0] = title;
            entry[1] = director;
        }
        db.close();
        return entry;
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

}
