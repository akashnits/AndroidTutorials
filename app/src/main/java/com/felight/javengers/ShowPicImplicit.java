package com.felight.javengers;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;


public class ShowPicImplicit extends AppCompatActivity {

    private ImageView akashView;
    private Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pic_implicit);
        akashView = (ImageView) findViewById(R.id.ivAkash);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent i = getIntent();
        b = i.getExtras();
        //akashView.setImageResource(b.getInt(Intent.EXTRA_STREAM));
        akashView.setImageURI((Uri)b.get(Intent.EXTRA_STREAM));
    }
    public void turnToGrayScale(View view)
    {
        Bitmap pic = BitmapFactory.decodeResource(getBaseContext().getResources(),b.getInt(Intent.EXTRA_STREAM));
        Bitmap finalImage = Bitmap.createBitmap(pic.getHeight(),pic.getWidth(), pic.getConfig());

        int argb;
        int pixelColor;

        for(int x=0; x< pic.getHeight();x++)
        {
            for(int y=0; y< pic.getWidth(); y++)
            {
                pixelColor= pic.getPixel(x,y);
                argb = Color.argb(Color.alpha(pixelColor), Color.red(255-pixelColor), Color.green(255 - pixelColor), Color.blue(255-pixelColor));
                finalImage.setPixel(x,y,argb);
                akashView.setImageBitmap(finalImage);
            }
        }

    }
}
