package com.felight.javengers;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewAnimation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);

    }
    public void startAnimation(View view) {
        float dest = 0;
        ImageView aniView = (ImageView) findViewById(R.id.imageView1);
        switch (view.getId()) {

            case R.id.Button01:

                ObjectAnimator animation1 = ObjectAnimator.ofFloat(aniView, "rotation", 0,90,0,360);
                animation1.setDuration(4000);
                animation1.start();
                break;

            case R.id.Button02:
                // shows how to define a animation via code
                // also use an Interpolator (BounceInterpolator)
                Paint paint = new Paint();
                TextView aniTextView = (TextView) findViewById(R.id.textView1);

                 float width = paint.measureText(aniTextView.getText()
                        .toString());
                ObjectAnimator animation2 = ObjectAnimator.ofFloat(aniTextView,
                        "translationX", -width,0,width,0);

                animation2.setDuration(2000);
                animation2.start();
                break;

            case R.id.Button03:
                // demonstrate fading and adding an AnimationListener

                dest = 1;
                if (aniView.getAlpha() > 0) {
                    dest = 0;
                }
                ObjectAnimator animation3 = ObjectAnimator.ofFloat(aniView,
                        "alpha", dest);
                animation3.setDuration(2000);
                animation3.start();
                break;

            case R.id.Button04:

                ObjectAnimator fadeOut = ObjectAnimator.ofFloat(aniView, "alpha",
                        0f);
                fadeOut.setDuration(3000);
                ObjectAnimator mover = ObjectAnimator.ofFloat(aniView,
                        "translationX",0f, -500f, 0f,500f,0f);
                mover.setDuration(3000);
                ObjectAnimator fadeIn = ObjectAnimator.ofFloat(aniView, "alpha",
                        0f, 1f);
                fadeIn.setDuration(3000);

                ObjectAnimator rotator = ObjectAnimator.ofFloat(aniView, "rotation", 0f,360f,0f);
                rotator.setDuration(3000);
                AnimatorSet animatorSet = new AnimatorSet();

                animatorSet.play(mover).with(fadeIn).with(rotator).after(fadeOut);
                animatorSet.start();
                break;

            default:
                break;
        }
}}
