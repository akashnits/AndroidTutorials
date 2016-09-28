package com.felight.javengers;

import java.util.List;
import java.util.Random;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class SQLiteDemo extends ListActivity {
    private CommentsDataSource datasource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_demo);

        datasource = new CommentsDataSource(this);
        datasource.open();

        List<Comment> values = datasource.getAllComments();

     ArrayAdapter<Comment> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,values);
        setListAdapter(arrayAdapter);
    }

    // Will be called via the onClick attribute
    // of the buttons in main.xml
    public void onClick(View view) {
        Comment obj1 = new Comment("akash", "akash@gmail.com");
        Comment obj2 = new Comment("john", "john@gmail.com");
        Comment obj3 = new Comment("maria", "maria@gmail.com");

        Comment[] objectArray = new Comment[]{obj1, obj2, obj3};

        @SuppressWarnings("unchecked")
        ArrayAdapter<Comment> adapter = (ArrayAdapter<Comment>) getListAdapter();
        Comment comment;
        switch (view.getId()) {
            case R.id.add:
                Random rand = new Random();
                int randomNum = rand.nextInt(3);
                comment = datasource.createComment(objectArray[randomNum]);
                adapter.add(comment);
                break;
            case R.id.delete:
                if (getListAdapter().getCount() > 0) {
                    comment = (Comment) getListAdapter().getItem(0);
                    datasource.deleteComment(comment);
                    adapter.remove(comment);
                }
                break;
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        datasource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }

}