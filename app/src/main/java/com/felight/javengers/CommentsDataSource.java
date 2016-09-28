package com.felight.javengers;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CommentsDataSource {

    private Context context;
    private MySQLiteHelper dbHelper;
    private SQLiteDatabase database;

    public CommentsDataSource(Context context)
    {
        this.context = context;
        dbHelper = new MySQLiteHelper(context);
    }
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close()
    {
        dbHelper.close();
    }
    public Comment createComment(Comment comment)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySQLiteHelper.COLUMN_NAME, comment.getName());
        contentValues.put(MySQLiteHelper.COLUMN_EMAIL, comment.getEmail());
        long id  = database.insert(MySQLiteHelper.TABLE_NAME, null, contentValues);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_NAME, new String[] {MySQLiteHelper.COLUMN_ID, MySQLiteHelper.COLUMN_NAME,
        MySQLiteHelper.COLUMN_EMAIL}, MySQLiteHelper.COLUMN_ID + "=" + id, null, null, null, null);
        Comment newComment = cursorToComment(cursor);
        cursor.close();
        return newComment;
    }

    public void deleteComment(Comment comment)
    {
        long id = comment.getId();
        database.delete(MySQLiteHelper.TABLE_NAME, MySQLiteHelper.COLUMN_ID + "=" + id, null);
    }

    public ArrayList<Comment> getAllComments()
    {
        ArrayList<Comment> akashList = new ArrayList<>();
        Cursor cursor = database.query(MySQLiteHelper.TABLE_NAME, new String[] {MySQLiteHelper.COLUMN_ID, MySQLiteHelper.COLUMN_NAME,
                MySQLiteHelper.COLUMN_EMAIL},null,null,null,null,null);
        cursor.moveToFirst();
        while(!(cursor.isAfterLast()))
        {
           akashList.add(cursorToComment(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        return akashList;
    }
    private Comment cursorToComment(Cursor cursor)
    {
        cursor.moveToFirst();
        Comment akashComment=new Comment();
        akashComment.setId(cursor.getInt(0));
        akashComment.setName(cursor.getString(1));
        akashComment.setEmail(cursor.getString(2));
        return akashComment;
    }
}