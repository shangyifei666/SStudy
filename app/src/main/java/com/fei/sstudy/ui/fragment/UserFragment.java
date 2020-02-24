package com.fei.sstudy.ui.fragment;


import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.fei.sstudy.R;
import com.fei.sstudy.entity.Action;
import com.fei.sstudy.entity.Config;
import com.fei.sstudy.entity.Student;
import com.fei.sstudy.ui.LoginActivity;
import com.fei.sstudy.util.JsoupUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment implements View.OnClickListener {

    private Button btnLogin;
    private TextView tv_sName;
    private TextView tv_sCollege;
    private ContentLoadingProgressBar lodingBar;
    /**
     * todo 学号的保存处理
     */

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            closeLoadingBar();//进度条关闭

            switch (msg.what){
                case Action.SHOW_STUDENT:
                    Student student = Student.getInstance();
                    tv_sName.setText(student.getName());
                    tv_sCollege.setText(student.getCollege());
                    break;

                case Action.SHOU_LOGIN_BUTTON:
                    btnLogin.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        initView(view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadStudent();
    }

    @Override
    public void onPause() {
        super.onPause();
        btnLogin.setVisibility(View.GONE);
    }

    private void initView(View view){
        btnLogin = view.findViewById(R.id.btn_login);
        tv_sName = view.findViewById(R.id.tv_name);
        tv_sCollege = view.findViewById(R.id.tv_college);
        lodingBar = view.findViewById(R.id.loding_bar);
        //设置加载条颜色
        lodingBar.getIndeterminateDrawable().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.MULTIPLY);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                toLogin();
                break;
        }
    }

    private void toLogin(){
        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivity(intent);
    }

    private void loadStudent(){
        Student student = Student.getInstance();
        if (student.getName()==null || student.getName().equals("") || student.getCollege()==null || student.getCollege().equals("")){
            setLoadingBar();
            /**
             * todo 优化线程启动方式
             */
            new Thread(new Runnable() {
                @Override
                public void run() {
                    JsoupUtil jsoupUtil = new JsoupUtil(getContext());
                    if (jsoupUtil.getStudent(Config.STUDENT)){
                        mHandler.sendEmptyMessage(Action.SHOW_STUDENT);
                    } else {
                        mHandler.sendEmptyMessage(Action.SHOU_LOGIN_BUTTON);
                    }
                }
            }).start();
        } else {
            mHandler.sendEmptyMessage(Action.SHOW_STUDENT);
        }
    }

    private void setLoadingBar(){
        lodingBar.setVisibility(View.VISIBLE);
    }

    private void closeLoadingBar(){
        lodingBar.setVisibility(View.GONE);
    }
}
