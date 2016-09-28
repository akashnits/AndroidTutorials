package com.felight.javengers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "comments";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";

    private static final String DATABASE_NAME = "myDb";
    private static final int DATABASE_VERSION = 1;

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("+
            COLUMN_ID + " integer primary key autoincrement, "+
            COLUMN_NAME + " text not null," +
            COLUMN_EMAIL + " text not null" + ");";

    public MySQLiteHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }
}