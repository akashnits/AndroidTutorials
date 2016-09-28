package com.felight.javengers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebViewDemoActivity extends AppCompatActivity {

    private WebView wvResult;
    private ProgressBar pbWebProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_demo);
        wvResult = (WebView) findViewById(R.id.wvResult);
        pbWebProgress = (ProgressBar) findViewById(R.id.pbWebProgress);
    }

    @Override
    protected void onStart() {
        super.onStart();
        pbWebProgress.setVisibility(View.VISIBLE);
        wvResult.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pbWebProgress.setVisibility(View.INVISIBLE);
            }
        });
        WebSettings webSettings = wvResult.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wvResult.loadUrl("http://msn.com");
        //wvResult.setWebChromeClient(new WebChromeClient());
    }
}
