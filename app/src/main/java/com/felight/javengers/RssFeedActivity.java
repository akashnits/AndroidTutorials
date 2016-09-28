package com.felight.javengers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RssFeedActivity extends AppCompatActivity implements myFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss_feed);
    }


    @Override
    public void rssFeedUpdate(String a) {
        DetailsFragment fragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);
        fragment.setText(a);
    }
}
