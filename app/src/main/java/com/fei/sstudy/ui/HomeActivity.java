package com.fei.sstudy.ui;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTabHost;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fei.sstudy.R;
import com.fei.sstudy.ui.fragment.ScheduleFragment;
import com.fei.sstudy.ui.fragment.ToolFragment;
import com.fei.sstudy.ui.fragment.UserFragment;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = "HomeActivity";

    private ToolFragment mToolFragment;
    private ScheduleFragment mScheduleFragment;
    private UserFragment mUserFragment;

    private FrameLayout mToolLayout;
    private FrameLayout mScheduleLayout;
    private FrameLayout mUserLayout;
    private FragmentTabHost mFragment;

    private TextView toolText;
    private TextView scheduleText;
    private TextView userText;
    private ImageView toolImg;
    private ImageView scheduleImg;
    private ImageView userImg;

    private Fragment mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
        initFragment();
    }

    private void initView(){
        mToolLayout = findViewById(R.id.touch_tool);
        mScheduleLayout = findViewById(R.id.touch_schedule);
        mUserLayout = findViewById(R.id.touch_user);
        mFragment = findViewById(R.id.heart_fragment);

        toolText= (TextView) mToolLayout.getChildAt(1);
        scheduleText= (TextView) mScheduleLayout.getChildAt(1);
        userText= (TextView) mUserLayout.getChildAt(1);
        toolText.setText("工具");
        scheduleText.setText("课程表");
        userText.setText("我");

        toolImg = (ImageView) mToolLayout.getChildAt(0);
        scheduleImg = (ImageView) mScheduleLayout.getChildAt(0);
        userImg = (ImageView) mUserLayout.getChildAt(0);
        toolImg.setImageResource(R.mipmap.tool);
        scheduleImg.setImageResource(R.mipmap.schedule2);
        userImg.setImageResource(R.mipmap.user);

        mToolLayout.setOnClickListener(this);
        mScheduleLayout.setOnClickListener(this);
        mUserLayout.setOnClickListener(this);
    }

    private void initFragment(){
        mScheduleLayout.performClick();
    }

    @Override
    public void onClick(View v) {
        changeImage(v);
        switchContent(v);
    }

    private void switchContent(View view){
        Fragment fragment;
        if (view == mToolLayout){
            if (mToolFragment == null){
                mToolFragment = new ToolFragment();
            }
            fragment = mToolFragment;
        } else if (view == mScheduleLayout){
            if (mScheduleFragment == null){
                mScheduleFragment = new ScheduleFragment();
            }
            fragment = mScheduleFragment;
        } else if (view == mToolLayout){
            if (mToolFragment == null) {
                mToolFragment = new ToolFragment();
            }
            fragment = mToolFragment;
        } else {
            return;
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (mContent == null){
            transaction.add(mFragment.getId(),fragment).commit();
            mContent = fragment;
        }
        if (mContent != fragment){
            if (!fragment.isAdded()){
                transaction.hide(mContent).add(fragment.getId(),fragment).commitAllowingStateLoss();
            } else {
                transaction.hide(mContent).show(fragment).commitAllowingStateLoss();
            }
            mContent = fragment;
        }
    }

    private void changeImage(View view){
        switch (view.getId()){
            case R.id.touch_tool:
                toolText.setTextColor(this.getResources().getColor(R.color.color_system_text,null));
                scheduleText.setTextColor(this.getResources().getColor(R.color.color_text,null));
                userText.setTextColor(this.getResources().getColor(R.color.color_text,null));
                toolImg.setImageResource(R.mipmap.tool2);
                scheduleImg.setImageResource(R.mipmap.schedule);
                userImg.setImageResource(R.mipmap.user);
                break;

            case R.id.touch_schedule:
                toolText.setTextColor(this.getResources().getColor(R.color.color_text,null));
                scheduleText.setTextColor(this.getResources().getColor(R.color.color_system_text,null));
                userText.setTextColor(this.getResources().getColor(R.color.color_text,null));
                toolImg.setImageResource(R.mipmap.tool);
                scheduleImg.setImageResource(R.mipmap.schedule2);
                userImg.setImageResource(R.mipmap.user);
                break;

            case R.id.touch_user:
                toolText.setTextColor(this.getResources().getColor(R.color.color_text,null));
                scheduleText.setTextColor(this.getResources().getColor(R.color.color_text,null));
                userText.setTextColor(this.getResources().getColor(R.color.color_system_text,null));
                toolImg.setImageResource(R.mipmap.tool);
                scheduleImg.setImageResource(R.mipmap.schedule);
                userImg.setImageResource(R.mipmap.user2);
                break;
        }
    }
}
