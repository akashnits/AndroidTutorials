package com.felight.javengers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ContextMenu extends AppCompatActivity {
    private ListView lvAkashView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);
        lvAkashView = (ListView) findViewById(R.id.lvAkashView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayList<String> contacts = new ArrayList<>(5);
        contacts.add("George");contacts.add("Mary");contacts.add("King");contacts.add("Tommy");contacts.add("Lucifer");
        String[] Contacts = new String[contacts.size()];
        Contacts = contacts.toArray(Contacts);
        ArrayAdapter<String> mAdapter = new ArrayAdapter<>(getBaseContext(),android.R.layout.simple_list_item_1,Contacts);
        lvAkashView.setAdapter(mAdapter);
        registerForContextMenu(lvAkashView);
    }

    @Override
    public void onCreateContextMenu(android.view.ContextMenu menu, View v, android.view.ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderIcon(R.drawable.ic_action_refresh);
        menu.setHeaderTitle("Choose one of the below");
        menu.add(0,v.getId(),0,"Call");
        menu.add(0,v.getId(),0,"Message");
        menu.add(0,v.getId(),0,"WhatsApp");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

       if(item.getTitle() == "Call")
       {
           Toast.makeText(getBaseContext(),"Make a call", Toast.LENGTH_LONG).show();
       }
        if(item.getTitle() == "Message")
        {
            Toast.makeText(getBaseContext(),"Write a message", Toast.LENGTH_LONG).show();
            Intent chooser =Intent.createChooser(new Intent(Intent.ACTION_VIEW),"Select");
            startActivity(chooser);
        }
        if(item.getTitle() == "WhatsApp")
        {
            Toast.makeText(getBaseContext(),"Type WhatsApp message", Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);
    }
}
