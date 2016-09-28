package com.felight.javengers;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ActivityTransition extends AppCompatActivity {

    private ImageView sharedImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_transition);
        sharedImage = (ImageView) findViewById(R.id.sharedimage);
    }

    public void onClick(View view)
    {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ActivityTransition.this,sharedImage,"sharedImage" );
        Intent intent = new Intent(getBaseContext(), SecondActivity.class);

        startActivity(intent, options.toBundle());
    }
}
