package com.felight.javengers;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.zip.Inflater;

public class OptionsMenu extends AppCompatActivity {

    private RelativeLayout akashLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        akashLayout = (RelativeLayout) findViewById(R.id.akashLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main,menu);
        /*MenuItem locationItem = menu.add(0, R.id.refresh, 0, R.string.refresh);
        locationItem.setIcon(R.drawable.ic_action_refresh);

        // Need to use MenuItemCompat methods to call any action item related methods
        MenuItemCompat.setShowAsAction(locationItem, MenuItem.SHOW_AS_ACTION_IF_ROOM);*/
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_settings:
                if(item.isChecked())
                {item.setCheckable(false);}
                else{
                    Intent intent = new Intent(Settings.ACTION_SETTINGS);
                    startActivity(intent);
                }
                break;
            case R.id.red:
                if(item.isChecked())
                {item.setCheckable(false);}
                else{akashLayout.setBackgroundColor(Color.RED);}
                break;
            case R.id.blue:
                if(item.isChecked())
                {item.setCheckable(false);}
                else{akashLayout.setBackgroundColor(Color.BLUE);}
                break;
            case R.id.home:
                if(item.isChecked())
                {item.setCheckable(false);}
                else{
                    Intent startMain = new Intent(Intent.ACTION_MAIN);
                    startMain.addCategory(Intent.CATEGORY_HOME);
                    startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(startMain);
                }
        }

        return super.onOptionsItemSelected(item);
    }
}
