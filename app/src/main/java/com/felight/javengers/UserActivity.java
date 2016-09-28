package com.felight.javengers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    private TextView tvUserName;
    private TextView tvUserAddress;
    private Button rUserDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        tvUserName = (TextView) findViewById(R.id.tvUserName);
        tvUserAddress = (TextView) findViewById(R.id.tvUserAddress);
        rUserDetails = (Button) findViewById(R.id.btRetrieveUserDetails);
    }
    @Override
    protected void onStart() {
        super.onStart();
        rUserDetails.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getBaseContext(),RetrieveActivity.class);
                        startActivityForResult(intent,100);
                    }
                }
        );
    }

    /*public void rUserDetails(View view)
    {
        Intent intent = new Intent(getBaseContext(), retrieveUserDetails.class);
        startActivityForResult(intent,100);
    }*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100)
        {
            if(resultCode == RESULT_OK)
            {
                Bundle a = data.getBundleExtra("dataBundle");
                tvUserName.setText(a.getString("name"));
                tvUserAddress.setText(a.getString("address"));
            }
        }
    }
}
