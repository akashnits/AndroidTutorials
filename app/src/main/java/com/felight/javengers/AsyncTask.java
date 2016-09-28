package com.felight.javengers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AsyncTask extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

    }

    public void doSomething(View view)
    {
        MyTask myTask = new MyTask(this);
        myTask.execute(2500,2500,2500,2500);
    }

}
