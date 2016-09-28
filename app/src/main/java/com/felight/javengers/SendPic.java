package com.felight.javengers;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SendPic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_pic);
    }

    @Override
    protected void onStart() {
        super.onStart();
        /* Intent picIntent = new Intent(Intent.ACTION_VIEW);

        picIntent.putExtra(Intent.EXTRA_STREAM, R.drawable.sample1);
        picIntent.setType("image/*");
        startActivity(Intent.createChooser(picIntent, "lazyPanda"));*/
    }
}
