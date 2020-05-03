package com.learners.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onSubmit(View view) {
        EditText heightBox=(EditText)findViewById(R.id.height);
        EditText weightBox=(EditText)findViewById(R.id.weight);
        TextView bmi=(TextView)findViewById(R.id.bmiText);
        TextView result=(TextView)findViewById(R.id.result);
        try {
            double height = Integer.parseInt(heightBox.getText().toString())/100.0;
            double weight = Integer.parseInt(weightBox.getText().toString());
            double bmiVal=weight/(double)(height*height);
            DecimalFormat df = new DecimalFormat("#.#");
            bmi.setText("BMI : "+String.valueOf(df.format(bmiVal)));
            String res="";
            if(bmiVal<18.5) res="Thin";
            if(bmiVal>=18.6 && bmiVal<=24.9) res="Normal";
            if(bmiVal>=25.0 && bmiVal<=29.9) res="Overweight";
            if(bmiVal>=30.0) res="Obese";
            result.setText("Result : "+res);
        }
        catch (Exception e) {
            Toast.makeText(MainActivity.this, "Please Enter Integer inputs!", Toast.LENGTH_SHORT).show();
        }
    }
}
