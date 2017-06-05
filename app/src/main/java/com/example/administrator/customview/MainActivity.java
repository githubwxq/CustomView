package com.example.administrator.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.customview.View.progressview;

public class MainActivity extends AppCompatActivity {
progressview  progreess_1;
    progressview  progreess_2;

    progressview  progreess_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view=new progressview(this);
        setContentView(R.layout.activity_main);

        progreess_1= (progressview) findViewById(R.id.progreess_1);
        progreess_1.setMaxCount(100f);
        progreess_1.setCurrentCount(70);
        progreess_1.setOneLine(90);



        progreess_2= (progressview) findViewById(R.id.progreess_2);
        progreess_2.setMaxCount(100f);
        progreess_2.setCurrentCount(100f);


        progreess_2.setOneLine(60);



        progreess_3= (progressview) findViewById(R.id.progreess_3);
        progreess_3.setMaxCount(100f);
        progreess_3.setTwoLine(50f,90f);


        progreess_3.setCurrentCount(65f);




    }
}
