package com.fei.sstudy.ui.fragment;


import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fei.sstudy.R;
import com.fei.sstudy.entity.Course;
import com.fei.sstudy.util.StatusBarUtils;
import com.fei.sstudy.view.scheduleView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment implements View.OnClickListener {

    private ImageView iv_refrush;


    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        changeStatusBar();
        initView(view);

        return view;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        changeStatusBar();
    }

    private void initView(View view){
        iv_refrush = view.findViewById(R.id.iv_refresh);
        iv_refrush.setOnClickListener(this);
    }

    /**
     * 改变状态栏颜色
     */
    private void changeStatusBar(){
        StatusBarUtils.setWindowStatusBarColor(getActivity(),getResources().getColor(R.color.color_shedule_system));
        StatusBarUtils.setWindowTextLightBarColor(getActivity());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_refresh:
                refrushAnimator();
                break;
        }
    }

    /**
     * 刷新的属性动画
     */
    private void refrushAnimator(){
        ObjectAnimator.ofFloat(iv_refrush,"rotation",0f,360f)
                .setDuration(1000)
                .start();
    }

}
