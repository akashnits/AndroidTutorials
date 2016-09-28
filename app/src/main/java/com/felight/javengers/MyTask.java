package com.felight.javengers;

import android.app.Activity;
import android.os.*;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MyTask extends android.os.AsyncTask<Integer, Float, String>{

    private Button btDoSomething;
    private Activity activity;
    private TextView tvCompletion;
    private float progress;
    private ProgressBar pbAkash;


    public MyTask(Activity activity)
    {
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        btDoSomething = (Button) activity.findViewById(R.id.btDoSomething);
        tvCompletion = (TextView) activity.findViewById(R.id.tvCompletion);
        pbAkash = (ProgressBar) activity.findViewById(R.id.pbAkash);
    }



    @Override
    protected String doInBackground(Integer... params) {

        for(Integer integer:params)
        {
            try {
                Thread.sleep(integer);
            }catch (Exception  e) {
                e.printStackTrace();
            }
            progress = progress +2.5f;
            publishProgress(progress);
        }
        return "Task Completed";
    }

    @Override
    protected void onProgressUpdate(Float... values) {
        super.onProgressUpdate(values);

        pbAkash.setProgress((int) progress);
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tvCompletion.setText(s);
    }
}
