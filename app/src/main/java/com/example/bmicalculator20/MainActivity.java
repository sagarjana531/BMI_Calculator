package com.example.bmicalculator20;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent inte=new Intent(MainActivity.this,KnowMore.class);

        final boolean[] flag = {false};
        EditText edtweight,edtheightFeet,edtheightInch;
        Button btnCalculate,knowbtn;
        TextView txtResult,BMIis;
        LinearLayout llmain;
        llmain=findViewById(R.id.llmain);
        edtweight=findViewById(R.id.edtweight);
        edtheightFeet=findViewById(R.id.edtheightFeet);
        edtheightInch=findViewById(R.id.edtheightInch);
        btnCalculate=findViewById(R.id.btnCalculate);
        txtResult=findViewById(R.id.txtResult);
        BMIis=findViewById(R.id.BMIis);
        knowbtn=findViewById(R.id.knowbtn);
       // init

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                try {
                    int weight=Integer.parseInt(edtweight.getText().toString());
                    int feet=Integer.parseInt(edtheightFeet.getText().toString());
                    int inch=Integer.parseInt(edtheightInch.getText().toString());
                    int total_inch=(feet*12)+inch;
                    double totalCM=total_inch*2.54;
                    double totalM=totalCM/(100);
                    flag[0] =true;
                    double bmi=(double)weight/(totalM*totalM);
                    inte.putExtra("weight",weight);
                    inte.putExtra("heightM",totalM);
                    inte.putExtra("BMI",bmi);
                    if(bmi>25)
                    {
                        txtResult.setText("You are OverWeight");
                        BMIis.setText("Your BMI is = "+(int)bmi);
                        llmain.setBackgroundColor(getResources().getColor(R.color.redOverweight));

                    }
                    else if (bmi<18)
                    {
                        txtResult.setText("You are UnderWight");
                        BMIis.setText("Your BMI is = "+(int)bmi);
                        llmain.setBackgroundColor(getResources().getColor(R.color.yellowUnderWeight));
                    }
                    else
                    {
                        txtResult.setText("You are Healthy ");
                        BMIis.setText("Your BMI is = "+(int)bmi);
                        llmain.setBackgroundColor(getResources().getColor(R.color.greenHealthy));
                    }
                }
                catch (Exception e)
                {
                   e.printStackTrace();
                }

            }
        });


        knowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag[0]) {
                    startActivity(inte);
                }


            }
        });






    }
}