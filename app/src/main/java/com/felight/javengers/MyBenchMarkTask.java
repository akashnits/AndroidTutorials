package com.felight.javengers;

import android.app.Activity;
import android.os.*;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by akash.raj on 6/29/2016.
 */
public class MyBenchMarkTask extends android.os.AsyncTask<Integer, Long, String>{

    private Activity activity;
    private TextView tvTime1;
    private TextView tvTime2;
    private TextView tvTime3;
    private TextView tvTime4;
    private static Long bTime;
    private static Long sTime;
    private static Long mTime;
    private static Long iTime;


    public MyBenchMarkTask(Activity activity)
    {
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        tvTime1 = (TextView) activity.findViewById(R.id.tvTime1);
        tvTime2 = (TextView) activity.findViewById(R.id.tvTime2);
        tvTime3 = (TextView) activity.findViewById(R.id.tvTime3);
        tvTime4 = (TextView) activity.findViewById(R.id.tvTime4);

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(activity,s,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onProgressUpdate(Long... values) {
        super.onProgressUpdate(values);
        tvTime1.setText(""+  bTime);
        tvTime2.setText(""+ sTime);
        tvTime3.setText(""+ mTime);
        tvTime4.setText(""+ iTime);
    }

    @Override
    protected String doInBackground(Integer... params) {

    for(Integer integer:params) {
    switch (integer) {
        case 1:
            bTime = GeneratingArray.bSort();
            publishProgress(bTime);
            break;
        case 2:
            sTime = GeneratingArray.sSort();
            publishProgress(sTime);
            break;
        case 3:
            mTime = GeneratingArray.mSort();
            publishProgress(mTime);
            break;
        case 4:
            iTime = GeneratingArray.iSort();
            publishProgress(iTime);
            break;
    }
}
        return "Completed" ;

    }
}
