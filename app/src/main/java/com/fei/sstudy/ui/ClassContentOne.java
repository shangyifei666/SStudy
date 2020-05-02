package com.fei.sstudy.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.fei.sstudy.R;
import com.fei.sstudy.util.StatusBarUtils;

public class ClassContentOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_content_one);

        changeStatusBar();
    }

    private void changeStatusBar(){
        StatusBarUtils.setWindowStatusBarColor(this,getResources().getColor(R.color.color_shedule_system));
        StatusBarUtils.setWindowTextLightBarColor(this);
    }
}
