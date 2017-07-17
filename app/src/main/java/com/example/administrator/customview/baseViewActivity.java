package com.example.administrator.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.customview.View.PieData;
import com.example.administrator.customview.View.PieView;

import java.util.ArrayList;

public class baseViewActivity extends AppCompatActivity {
PieView pv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_view);

        pv= (PieView) findViewById(R.id.pv);
        ArrayList<PieData> datas=new ArrayList<>();
        PieData a=new PieData("1111",100);
        PieData b=new PieData("222",200);
        PieData c=new PieData("11311",300);
        PieData d=new PieData("11311",400);
        PieData e=new PieData("11111",500);
        datas.add(a);
        datas.add(b);
        datas.add(c);
        datas.add(d);
        datas.add(e);
        pv.setData(datas);
    }
}
