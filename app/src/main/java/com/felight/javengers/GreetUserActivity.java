package com.felight.javengers;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GreetUserActivity extends AppCompatActivity {

    private final static String TAG = GreetUserActivity.class.getSimpleName();

    public void greetUser(View view){
        Log.i(TAG, "greet user called");

        EditText etName = (EditText) findViewById(R.id.etName);
        TextView tvResult = (TextView) findViewById(R.id.tvResult);
        String userName =  etName.getText().toString();

        tvResult.setText(userName);
        tvResult.setTextColor(Color.YELLOW);
        Log.i(TAG, "Namaste " + userName);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.greet_user_layout);
    }
}
