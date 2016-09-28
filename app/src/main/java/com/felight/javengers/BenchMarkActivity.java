package com.felight.javengers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Random;

public class BenchMarkActivity extends AppCompatActivity {

    private EditText arraySize;
    private TextView bubbleTime;
    private TextView selectionTime;
    private Button benchMark;
    private GridLayout gl;
    private TextView insertionTime;
    private TextView mergeTime;
    private View selectedRadio;

    public void onRadioButtonSelected(View view)
    {
        selectedRadio= view;
    }


    public void generateArray(View view)
    {
        int size = Integer.parseInt(arraySize.getText().toString());

     switch (selectedRadio.getId())
     {
         case R.id.rb1:
             GeneratingArray.averageCaseArray(size);
             Toast.makeText(getBaseContext(), "array of size created    " + size ,
                     Toast.LENGTH_LONG).show();
             gl.setVisibility(View.VISIBLE);
             benchMark.setVisibility(View.VISIBLE);
             break;
         case R.id.rb2:
             GeneratingArray.bestCaseArray(size);
             Toast.makeText(getBaseContext(), "array of size created    " + size ,
                     Toast.LENGTH_LONG).show();
             gl.setVisibility(View.VISIBLE);
             benchMark.setVisibility(View.VISIBLE);
             break;
         case R.id.rb3:
             GeneratingArray.worstCaseArray(size);
             Toast.makeText(getBaseContext(), "array of size created    " + size ,
                     Toast.LENGTH_LONG).show();
             gl.setVisibility(View.VISIBLE);
             benchMark.setVisibility(View.VISIBLE);
             break;
     }
    }
    public void bubbleSort(View view) {

      MyBenchMarkTask myBenchMarkTask = new MyBenchMarkTask(this);
        myBenchMarkTask.execute(1);
    }
    public void selectionSort(View view)
    {
        MyBenchMarkTask myBenchMarkTask = new MyBenchMarkTask(this);
        myBenchMarkTask.execute(2);
    }

    public void mergeSort(View view)
    {
        MyBenchMarkTask myBenchMarkTask = new MyBenchMarkTask(this);
        myBenchMarkTask.execute(3);
    }
    public void insertionSort(View view)
    {
        MyBenchMarkTask myBenchMarkTask = new MyBenchMarkTask(this);
        myBenchMarkTask.execute(4);
    }
    public void benchMark(View view) {

        MyBenchMarkTask myBenchMarkTask = new MyBenchMarkTask(this);
        myBenchMarkTask.execute(1,2,3,4);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bench_mark);
        arraySize = (EditText) findViewById(R.id.etArraySize);
        bubbleTime = (TextView) findViewById(R.id.tvTime1);
        selectionTime = (TextView) findViewById(R.id.tvTime2);
        mergeTime =(TextView) findViewById(R.id.tvTime3);
        insertionTime = (TextView) findViewById(R.id.tvTime4);
        selectedRadio = findViewById(R.id.rb1);
        gl = (GridLayout) findViewById(R.id.gridLayout);
        benchMark=(Button) findViewById(R.id.btBenchMark);
    }
}
