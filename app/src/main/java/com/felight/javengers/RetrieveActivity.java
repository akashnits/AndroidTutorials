package com.felight.javengers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RetrieveActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etAddress;
    private Button sendIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);
        etName = (EditText) findViewById(R.id.etName);
        etAddress = (EditText) findViewById(R.id.etAddress);
        sendIntent = (Button) findViewById(R.id.btSendIntent);
        sendIntent.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle b = new Bundle();
                        b.putString("name",etName.getText().toString());
                        b.putString("address", etAddress.getText().toString());
                        Intent myIntent = new Intent();
                        myIntent.putExtra("dataBundle",b);
                        setResult(RESULT_OK, myIntent);
                        finish();
                    }
                }
        );
    }
   /* public void sendIntent(View view)
    {
        Bundle b = new Bundle();
        b.putString("name",etName.getText().toString());
        b.putString("address", etAddress.getText().toString());
        Intent myIntent = new Intent();
        myIntent.putExtra("dataBundle",b);
        setResult(RESULT_OK, myIntent);
        finish();
    }*/
}
