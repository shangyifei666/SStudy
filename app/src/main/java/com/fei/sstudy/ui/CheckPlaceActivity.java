package com.fei.sstudy.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.fei.sstudy.R;
import com.fei.sstudy.entity.Action;
import com.fei.sstudy.ui.fragment.ScheduleFragment;

import java.util.ArrayList;
import java.util.List;

public class CheckPlaceActivity extends AppCompatActivity {
    private final String TAG = "CheckPlaceActivity";

    private Spinner mSpWeek;
    private Spinner mSpBegin;
    private Spinner mSpEnd;
    private List<String> mWeekList;
    private List<String> mClassList;
    private Adapter mWeekAdapter;
    private Adapter mClassAdapter;

    private String iWeek;
    private String iBegin;
    private String  iEnd;

    private Button btnOk;
    private ConstraintLayout mclClass;
    private Button btnClass1;
    private Button btnClass2;
    private Button btnClass3;
    private Button btnClass4;
    private Button btnClass5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_place);

        initData();
        initView();
    }

    private void initView(){
        mSpWeek = findViewById(R.id.sp_week);
        mSpBegin = findViewById(R.id.sp_begin);
        mSpEnd = findViewById(R.id.sp_end);

        mWeekList = new ArrayList<>();
        mWeekList.add("1");
        mWeekList.add("2");
        mWeekList.add("3");
        mWeekList.add("4");
        mWeekList.add("5");
        mWeekList.add("6");
        mWeekList.add("7");
        mClassList = new ArrayList<>();
        mClassList.add("1");
        mClassList.add("2");
        mClassList.add("3");
        mClassList.add("4");
        mClassList.add("5");
        mClassList.add("6");
        mClassList.add("7");
        mClassList.add("8");
        mClassList.add("9");
        mClassList.add("10");
        mClassList.add("11");
        mClassList.add("12");
        mClassList.add("13");

        mWeekAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mWeekList);
        mSpWeek.setAdapter((SpinnerAdapter) mWeekAdapter);
        mClassAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mClassList);
        mSpBegin.setAdapter((SpinnerAdapter) mClassAdapter);
        mSpEnd.setAdapter((SpinnerAdapter) mClassAdapter);

        mSpWeek.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                iWeek = mWeekList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mSpBegin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                iBegin = mClassList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mSpEnd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                iEnd = mClassList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mSpWeek.setSelection(Integer.valueOf(iWeek)-1);
        mSpBegin.setSelection(Integer.valueOf(iBegin)-1);
        mSpEnd.setSelection(Integer.valueOf(iEnd)-1);

        mclClass = findViewById(R.id.cl_class);

        btnOk = findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mclClass.setVisibility(View.VISIBLE);
            }
        });

        btnClass1 = findViewById(R.id.btn_class_1);
        btnClass2 = findViewById(R.id.btn_class_2);
        btnClass3 = findViewById(R.id.btn_class_3);
        btnClass4 = findViewById(R.id.btn_class_4);
        btnClass5 = findViewById(R.id.btn_class_5);
        btnClass1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = (Integer.valueOf(iWeek)-1)*13+Integer.valueOf(iBegin);
                int h = Integer.valueOf(iEnd)-Integer.valueOf(iBegin)+1;
                Intent intent = new Intent();
                intent.setAction(Action.ADD_CLASS);
                intent.putExtra("id",id);
                intent.putExtra("h",h);
                intent.putExtra("class","公交楼A-301");
                sendBroadcast(intent);
                finish();
            }
        });

        btnClass2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = (Integer.valueOf(iWeek)-1)*13+Integer.valueOf(iBegin);
                int h = Integer.valueOf(iEnd)-Integer.valueOf(iBegin)+1;
                Intent intent = new Intent();
                intent.setAction(Action.ADD_CLASS);
                intent.putExtra("id",id);
                intent.putExtra("h",h);
                intent.putExtra("class","公交楼B-403");
                sendBroadcast(intent);
                finish();
            }
        });

        btnClass3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = (Integer.valueOf(iWeek)-1)*13+Integer.valueOf(iBegin);
                int h = Integer.valueOf(iEnd)-Integer.valueOf(iBegin)+1;
                Intent intent = new Intent();
                intent.setAction(Action.ADD_CLASS);
                intent.putExtra("id",id);
                intent.putExtra("h",h);
                intent.putExtra("class","公交楼C-201");
                sendBroadcast(intent);
                finish();
            }
        });

        btnClass4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = (Integer.valueOf(iWeek)-1)*13+Integer.valueOf(iBegin);
                int h = Integer.valueOf(iEnd)-Integer.valueOf(iBegin)+1;
                Intent intent = new Intent();
                intent.setAction(Action.ADD_CLASS);
                intent.putExtra("id",id);
                intent.putExtra("h",h);
                intent.putExtra("class","软件学院C-302");
                sendBroadcast(intent);
                finish();
            }
        });

        btnClass5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = (Integer.valueOf(iWeek)-1)*13+Integer.valueOf(iBegin);
                int h = Integer.valueOf(iEnd)-Integer.valueOf(iBegin)+1;
                Intent intent = new Intent();
                intent.setAction(Action.ADD_CLASS);
                intent.putExtra("id",id);
                intent.putExtra("h",h);
                intent.putExtra("class","软件学院C-404");
                sendBroadcast(intent);
                finish();
            }
        });



    }

    private void initData(){
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        int h = intent.getIntExtra("h",0);
        Log.d(TAG,"id: "+id);
        Log.d(TAG,"h: "+h);
        iWeek = String.valueOf(id%13==0 ? id/13 : id/13+1);
        iBegin = String.valueOf(id%13==0 ? 13 : id%13);
        iEnd = String.valueOf(id%13==0 ? 13 : id % 13 + h - 1);
        Log.d(TAG,"iWeek: "+iWeek);
        Log.d(TAG,"iBegin: "+iBegin);
        Log.d(TAG,"iEnd: "+iEnd);
    }
}
