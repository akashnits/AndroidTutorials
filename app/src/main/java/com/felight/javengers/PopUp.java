 package com.felight.javengers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PopUp extends AppCompatActivity {
    private Button aaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_menu);

        aaButton = (Button) findViewById(R.id.btAkashButton);
    }

    @Override
    protected void onStart() {
        super.onStart();
        aaButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PopupMenu pMenu = new PopupMenu(PopUp.this,aaButton);//creating a object of PopUpMenu
                        pMenu.getMenuInflater().inflate(R.menu.main_menu,pMenu.getMenu());// inflating  popupmenu layout

                        pMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                Toast.makeText(getBaseContext(),"Item   clicked   " + item.getTitle(),Toast.LENGTH_LONG).show();
                                return true;
                            }
                        });
                        pMenu.show();

                    }
                }
        );
    }
}