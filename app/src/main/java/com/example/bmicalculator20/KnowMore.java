package com.example.bmicalculator20;

import android.annotation.SuppressLint;
//import android.content.Context;
import android.content.Intent;
//import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class KnowMore extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know_more);
        Intent fromAct=getIntent();
        ImageView image=findViewById(R.id.image);

        TextView BMInow=findViewById(R.id.BMInow);
        TextView weightsb=findViewById(R.id.weightsb);
        TextView message=findViewById(R.id.message);
        //int w=fromAct.getIntExtra("weight",0);
        double hm=fromAct.getDoubleExtra("heightM",0.0);
        double bmi=fromAct.getDoubleExtra("BMI",5.0);
        int wsb1=(int) (18*hm*hm);
        int wsb2=(int) (25*hm*hm);
        String s;
        if(bmi>25)
        {
           // wsb= (int) (25*hm*hm);
             s=new String("You should work out");
            //s=";
            image.setImageResource(R.drawable.obey);
        }
        else if(bmi<18)
        {
           // wsb= (int) (18*hm*hm);
            s=new String("You should put some weight");
             image.setImageResource(R.drawable.download);
        }
        else
        {
            s=new String("You are doing it great");
            image.setImageResource(R.drawable.fit);
        }


       BMInow.setText(" "+(int)bmi);
        //String s1=" ="+wsb1+" - +"+wsb2;
        weightsb.setText(" "+wsb1+" - "+wsb2);
        message.setText(new StringBuilder().append(" ").append(s).toString());
       // getSupportActionBar();
    }
}