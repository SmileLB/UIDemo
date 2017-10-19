package com.example.administrator.wxeffectdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.wxeffectdemo.activitys.Activity1;
import com.example.administrator.wxeffectdemo.activitys.Activity2;
import com.example.administrator.wxeffectdemo.activitys.Activity3;
import com.example.administrator.wxeffectdemo.activitys.Activity4;
import com.example.administrator.wxeffectdemo.activitys.Activity5;
import com.example.administrator.wxeffectdemo.activitys.Activity6;
import com.example.administrator.wxeffectdemo.activitys.Activity7;
import com.example.administrator.wxeffectdemo.activitys.Activity8;
import com.example.administrator.wxeffectdemo.activitys.Activity9;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn1:
                intent=new Intent(this, Activity1.class);
                startActivity(intent);
                break;
            case R.id.btn2:
                intent=new Intent(this, Activity2.class);
                startActivity(intent);
                break;
            case R.id.btn3:
                intent=new Intent(this, Activity3.class);
                startActivity(intent);
                break;
            case R.id.btn4:
                intent=new Intent(this, Activity4.class);
                startActivity(intent);
                break;
            case R.id.btn5:
                intent=new Intent(this, Activity5.class);
                startActivity(intent);
                break;
            case R.id.btn6:
                intent=new Intent(this, Activity6.class);
                startActivity(intent);
                break;
            case R.id.btn7:
                intent=new Intent(this, Activity7.class);
                startActivity(intent);
                break;
            case R.id.btn8:
                intent=new Intent(this, Activity8.class);
                startActivity(intent);
                break;
            case R.id.btn9:
                intent=new Intent(this, Activity9.class);
                startActivity(intent);
                break;
        }
    }
}
