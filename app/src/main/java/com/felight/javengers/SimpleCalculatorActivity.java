package com.felight.javengers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SimpleCalculatorActivity extends AppCompatActivity {

    private EditText etFirstNum;
    private EditText etSecondNum;
    private TextView tvResult;

    public void doCalculation(View view){
        boolean noException = true;
        double num1 = 0;
        double num2 =0;

        try{
            num1 = Double.parseDouble(etFirstNum.getText().toString());
        }catch (Exception ex){
            tvResult.setText("Enter first valid  number");
            noException = false;
        }
        try{
            num2= Double.parseDouble(etSecondNum.getText().toString());
        }catch (Exception e)
        {
          tvResult.setText("Enter valid second number");
            noException= false;
        }



        if(noException){
            switch (view.getId()){
                case R.id.btnAdd:
                    tvResult.setText("The addition of " + num1 + " & " + num2 + " is " + (num1+num2));
                    break;

                case R.id.btnSub:
                    tvResult.setText(""+(num1-num2));
                    break;

                case R.id.btnMul:
                    tvResult.setText(""+(num1*num2));
                    break;
                case R.id.btnDiv:
                    if(num2 != 0)
                    {
                        tvResult.setText(""+(num1/num2));
                    }
                    break;
                case R.id.btnMod:
                    tvResult.setText(""+(num1%num2));
                    break;
            }
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_calculator_layout);
        etFirstNum = (EditText) findViewById(R.id.etFirstNum);
        etSecondNum = (EditText) findViewById(R.id.etSecondNum);
        tvResult = (TextView) findViewById(R.id.tvResult);
    }
}
