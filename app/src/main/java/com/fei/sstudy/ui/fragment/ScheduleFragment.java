package com.fei.sstudy.ui.fragment;


import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fei.sstudy.R;
import com.fei.sstudy.entity.Course;
import com.fei.sstudy.util.StatusBarUtils;
import com.fei.sstudy.view.OnLongClickListener;
import com.fei.sstudy.view.scheduleView;

import com.fei.sstudy.entity.ScheduleViewId;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment implements View.OnClickListener {
    private final String TAG = "ScheduleFragment";

    private ImageView iv_refrush;

    private scheduleView sch_1_1;
    private scheduleView sch_1_2;
    private scheduleView sch_1_3;
    private scheduleView sch_1_4;
    private scheduleView sch_1_5;
    private scheduleView sch_1_6;
    private scheduleView sch_1_7;
    private scheduleView sch_1_8;
    private scheduleView sch_1_9;
    private scheduleView sch_1_10;
    private scheduleView sch_1_11;
    private scheduleView sch_1_12;
    private scheduleView sch_1_13;

    private scheduleView sch_2_1;
    private scheduleView sch_2_2;
    private scheduleView sch_2_3;
    private scheduleView sch_2_4;
    private scheduleView sch_2_5;
    private scheduleView sch_2_6;
    private scheduleView sch_2_7;
    private scheduleView sch_2_8;
    private scheduleView sch_2_9;
    private scheduleView sch_2_10;
    private scheduleView sch_2_11;
    private scheduleView sch_2_12;
    private scheduleView sch_2_13;

    private scheduleView sch_3_1;
    private scheduleView sch_3_2;
    private scheduleView sch_3_3;
    private scheduleView sch_3_4;
    private scheduleView sch_3_5;
    private scheduleView sch_3_6;
    private scheduleView sch_3_7;
    private scheduleView sch_3_8;
    private scheduleView sch_3_9;
    private scheduleView sch_3_10;
    private scheduleView sch_3_11;
    private scheduleView sch_3_12;
    private scheduleView sch_3_13;

    private scheduleView sch_4_1;
    private scheduleView sch_4_2;
    private scheduleView sch_4_3;
    private scheduleView sch_4_4;
    private scheduleView sch_4_5;
    private scheduleView sch_4_6;
    private scheduleView sch_4_7;
    private scheduleView sch_4_8;
    private scheduleView sch_4_9;
    private scheduleView sch_4_10;
    private scheduleView sch_4_11;
    private scheduleView sch_4_12;
    private scheduleView sch_4_13;

    private scheduleView sch_5_1;
    private scheduleView sch_5_2;
    private scheduleView sch_5_3;
    private scheduleView sch_5_4;
    private scheduleView sch_5_5;
    private scheduleView sch_5_6;
    private scheduleView sch_5_7;
    private scheduleView sch_5_8;
    private scheduleView sch_5_9;
    private scheduleView sch_5_10;
    private scheduleView sch_5_11;
    private scheduleView sch_5_12;
    private scheduleView sch_5_13;

    private scheduleView sch_6_1;
    private scheduleView sch_6_2;
    private scheduleView sch_6_3;
    private scheduleView sch_6_4;
    private scheduleView sch_6_5;
    private scheduleView sch_6_6;
    private scheduleView sch_6_7;
    private scheduleView sch_6_8;
    private scheduleView sch_6_9;
    private scheduleView sch_6_10;
    private scheduleView sch_6_11;
    private scheduleView sch_6_12;
    private scheduleView sch_6_13;

    private scheduleView sch_7_1;
    private scheduleView sch_7_2;
    private scheduleView sch_7_3;
    private scheduleView sch_7_4;
    private scheduleView sch_7_5;
    private scheduleView sch_7_6;
    private scheduleView sch_7_7;
    private scheduleView sch_7_8;
    private scheduleView sch_7_9;
    private scheduleView sch_7_10;
    private scheduleView sch_7_11;
    private scheduleView sch_7_12;
    private scheduleView sch_7_13;



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

        sch_1_1 = view.findViewById(R.id.sch_1_1);
        sch_1_2 = view.findViewById(R.id.sch_1_2);
        sch_1_3 = view.findViewById(R.id.sch_1_3);
        sch_1_4 = view.findViewById(R.id.sch_1_4);
        sch_1_5 = view.findViewById(R.id.sch_1_5);
        sch_1_6 = view.findViewById(R.id.sch_1_6);
        sch_1_7 = view.findViewById(R.id.sch_1_7);
        sch_1_8 = view.findViewById(R.id.sch_1_8);
        sch_1_9 = view.findViewById(R.id.sch_1_9);
        sch_1_10 = view.findViewById(R.id.sch_1_10);
        sch_1_11 = view.findViewById(R.id.sch_1_11);
        sch_1_12 = view.findViewById(R.id.sch_1_12);
        sch_1_13 = view.findViewById(R.id.sch_1_13);

        sch_2_1 = view.findViewById(R.id.sch_2_1);
        sch_2_2 = view.findViewById(R.id.sch_2_2);
        sch_2_3 = view.findViewById(R.id.sch_2_3);
        sch_2_4 = view.findViewById(R.id.sch_2_4);
        sch_2_5 = view.findViewById(R.id.sch_2_5);
        sch_2_6 = view.findViewById(R.id.sch_2_6);
        sch_2_7 = view.findViewById(R.id.sch_2_7);
        sch_2_8 = view.findViewById(R.id.sch_2_8);
        sch_2_9 = view.findViewById(R.id.sch_2_9);
        sch_2_10 = view.findViewById(R.id.sch_2_10);
        sch_2_11 = view.findViewById(R.id.sch_2_11);
        sch_2_12 = view.findViewById(R.id.sch_2_12);
        sch_2_13 = view.findViewById(R.id.sch_2_13);

        sch_3_1 = view.findViewById(R.id.sch_3_1);
        sch_3_2 = view.findViewById(R.id.sch_3_2);
        sch_3_3 = view.findViewById(R.id.sch_3_3);
        sch_3_4 = view.findViewById(R.id.sch_3_4);
        sch_3_5 = view.findViewById(R.id.sch_3_5);
        sch_3_6 = view.findViewById(R.id.sch_3_6);
        sch_3_7 = view.findViewById(R.id.sch_3_7);
        sch_3_8 = view.findViewById(R.id.sch_3_8);
        sch_3_9 = view.findViewById(R.id.sch_3_9);
        sch_3_10 = view.findViewById(R.id.sch_3_10);
        sch_3_11 = view.findViewById(R.id.sch_3_11);
        sch_3_12 = view.findViewById(R.id.sch_3_12);
        sch_3_13 = view.findViewById(R.id.sch_3_13);

        sch_4_1 = view.findViewById(R.id.sch_4_1);
        sch_4_2 = view.findViewById(R.id.sch_4_2);
        sch_4_3 = view.findViewById(R.id.sch_4_3);
        sch_4_4 = view.findViewById(R.id.sch_4_4);
        sch_4_5 = view.findViewById(R.id.sch_4_5);
        sch_4_6 = view.findViewById(R.id.sch_4_6);
        sch_4_7 = view.findViewById(R.id.sch_4_7);
        sch_4_8 = view.findViewById(R.id.sch_4_8);
        sch_4_9 = view.findViewById(R.id.sch_4_9);
        sch_4_10 = view.findViewById(R.id.sch_4_10);
        sch_4_11 = view.findViewById(R.id.sch_4_11);
        sch_4_12 = view.findViewById(R.id.sch_4_12);
        sch_4_13 = view.findViewById(R.id.sch_4_13);

        sch_5_1 = view.findViewById(R.id.sch_5_1);
        sch_5_2 = view.findViewById(R.id.sch_5_2);
        sch_5_3 = view.findViewById(R.id.sch_5_3);
        sch_5_4 = view.findViewById(R.id.sch_5_4);
        sch_5_5 = view.findViewById(R.id.sch_5_5);
        sch_5_6 = view.findViewById(R.id.sch_5_6);
        sch_5_7 = view.findViewById(R.id.sch_5_7);
        sch_5_8 = view.findViewById(R.id.sch_5_8);
        sch_5_9 = view.findViewById(R.id.sch_5_9);
        sch_5_10 = view.findViewById(R.id.sch_5_10);
        sch_5_11 = view.findViewById(R.id.sch_5_11);
        sch_5_12 = view.findViewById(R.id.sch_5_12);
        sch_5_13 = view.findViewById(R.id.sch_5_13);

        sch_6_1 = view.findViewById(R.id.sch_6_1);
        sch_6_2 = view.findViewById(R.id.sch_6_2);
        sch_6_3 = view.findViewById(R.id.sch_6_3);
        sch_6_4 = view.findViewById(R.id.sch_6_4);
        sch_6_5 = view.findViewById(R.id.sch_6_5);
        sch_6_6 = view.findViewById(R.id.sch_6_6);
        sch_6_7 = view.findViewById(R.id.sch_6_7);
        sch_6_8 = view.findViewById(R.id.sch_6_8);
        sch_6_9 = view.findViewById(R.id.sch_6_9);
        sch_6_10 = view.findViewById(R.id.sch_6_10);
        sch_6_11 = view.findViewById(R.id.sch_6_11);
        sch_6_12 = view.findViewById(R.id.sch_6_12);
        sch_6_13 = view.findViewById(R.id.sch_6_13);

        sch_7_1 = view.findViewById(R.id.sch_7_1);
        sch_7_2 = view.findViewById(R.id.sch_7_2);
        sch_7_3 = view.findViewById(R.id.sch_7_3);
        sch_7_4 = view.findViewById(R.id.sch_7_4);
        sch_7_5 = view.findViewById(R.id.sch_7_5);
        sch_7_6 = view.findViewById(R.id.sch_7_6);
        sch_7_7 = view.findViewById(R.id.sch_7_7);
        sch_7_8 = view.findViewById(R.id.sch_7_8);
        sch_7_9 = view.findViewById(R.id.sch_7_9);
        sch_7_10 = view.findViewById(R.id.sch_7_10);
        sch_7_11 = view.findViewById(R.id.sch_7_11);
        sch_7_12 = view.findViewById(R.id.sch_7_12);
        sch_7_13 = view.findViewById(R.id.sch_7_13);

        for (int i=ScheduleViewId.SCH_1_1; i<=ScheduleViewId.SCH_7_13; i++){
            final int finalI = i;
            findSchduleView(i).setLongClickListener(new OnLongClickListener() {
                @Override
                public void onLongClick() {
                    Log.d(TAG,"onLongClick: " + finalI);
                }

                @Override
                public void onViewHeightUp(int i) {
                    Log.d(TAG,"onViewHeightUP: " + finalI);
                }
            });
        }
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

    private scheduleView findSchduleView(int id){
        scheduleView s = null;
        switch (id){
            case ScheduleViewId.SCH_1_1:
                s = sch_1_1;
                break;
            case ScheduleViewId.SCH_1_2:
                s = sch_1_2;
                break;
            case ScheduleViewId.SCH_1_3:
                s = sch_1_3;
                break;
            case ScheduleViewId.SCH_1_4:
                s = sch_1_4;
                break;
            case ScheduleViewId.SCH_1_5:
                s = sch_1_5;
                break;
            case ScheduleViewId.SCH_1_6:
                s = sch_1_6;
                break;
            case ScheduleViewId.SCH_1_7:
                s = sch_1_7;
                break;
            case ScheduleViewId.SCH_1_8:
                s = sch_1_8;
                break;
            case ScheduleViewId.SCH_1_9:
                s = sch_1_9;
                break;
            case ScheduleViewId.SCH_1_10:
                s = sch_1_10;
                break;
            case ScheduleViewId.SCH_1_11:
                s = sch_1_11;
                break;
            case ScheduleViewId.SCH_1_12:
                s = sch_1_12;
                break;
            case ScheduleViewId.SCH_1_13:
                s = sch_1_13;
                break;

            case ScheduleViewId.SCH_2_1:
                s = sch_2_1;
                break;
            case ScheduleViewId.SCH_2_2:
                s = sch_2_2;
                break;
            case ScheduleViewId.SCH_2_3:
                s = sch_2_3;
                break;
            case ScheduleViewId.SCH_2_4:
                s = sch_2_4;
                break;
            case ScheduleViewId.SCH_2_5:
                s = sch_2_5;
                break;
            case ScheduleViewId.SCH_2_6:
                s = sch_2_6;
                break;
            case ScheduleViewId.SCH_2_7:
                s = sch_2_7;
                break;
            case ScheduleViewId.SCH_2_8:
                s = sch_2_8;
                break;
            case ScheduleViewId.SCH_2_9:
                s = sch_2_9;
                break;
            case ScheduleViewId.SCH_2_10:
                s = sch_2_10;
                break;
            case ScheduleViewId.SCH_2_11:
                s = sch_2_11;
                break;
            case ScheduleViewId.SCH_2_12:
                s = sch_2_12;
                break;
            case ScheduleViewId.SCH_2_13:
                s = sch_2_13;
                break;

            case ScheduleViewId.SCH_3_1:
                s = sch_3_1;
                break;
            case ScheduleViewId.SCH_3_2:
                s = sch_3_2;
                break;
            case ScheduleViewId.SCH_3_3:
                s = sch_3_3;
                break;
            case ScheduleViewId.SCH_3_4:
                s = sch_3_4;
                break;
            case ScheduleViewId.SCH_3_5:
                s = sch_3_5;
                break;
            case ScheduleViewId.SCH_3_6:
                s = sch_3_6;
                break;
            case ScheduleViewId.SCH_3_7:
                s = sch_3_7;
                break;
            case ScheduleViewId.SCH_3_8:
                s = sch_3_8;
                break;
            case ScheduleViewId.SCH_3_9:
                s = sch_3_9;
                break;
            case ScheduleViewId.SCH_3_10:
                s = sch_3_10;
                break;
            case ScheduleViewId.SCH_3_11:
                s = sch_3_11;
                break;
            case ScheduleViewId.SCH_3_12:
                s = sch_3_12;
                break;
            case ScheduleViewId.SCH_3_13:
                s = sch_3_13;
                break;

            case ScheduleViewId.SCH_4_1:
                s = sch_4_1;
                break;
            case ScheduleViewId.SCH_4_2:
                s = sch_4_2;
                break;
            case ScheduleViewId.SCH_4_3:
                s = sch_4_3;
                break;
            case ScheduleViewId.SCH_4_4:
                s = sch_4_4;
                break;
            case ScheduleViewId.SCH_4_5:
                s = sch_4_5;
                break;
            case ScheduleViewId.SCH_4_6:
                s = sch_4_6;
                break;
            case ScheduleViewId.SCH_4_7:
                s = sch_4_7;
                break;
            case ScheduleViewId.SCH_4_8:
                s = sch_4_8;
                break;
            case ScheduleViewId.SCH_4_9:
                s = sch_4_9;
                break;
            case ScheduleViewId.SCH_4_10:
                s = sch_4_10;
                break;
            case ScheduleViewId.SCH_4_11:
                s = sch_4_11;
                break;
            case ScheduleViewId.SCH_4_12:
                s = sch_4_12;
                break;
            case ScheduleViewId.SCH_4_13:
                s = sch_4_13;
                break;

            case ScheduleViewId.SCH_5_1:
                s = sch_5_1;
                break;
            case ScheduleViewId.SCH_5_2:
                s = sch_5_2;
                break;
            case ScheduleViewId.SCH_5_3:
                s = sch_5_3;
                break;
            case ScheduleViewId.SCH_5_4:
                s = sch_5_4;
                break;
            case ScheduleViewId.SCH_5_5:
                s = sch_5_5;
                break;
            case ScheduleViewId.SCH_5_6:
                s = sch_5_6;
                break;
            case ScheduleViewId.SCH_5_7:
                s = sch_5_7;
                break;
            case ScheduleViewId.SCH_5_8:
                s = sch_5_8;
                break;
            case ScheduleViewId.SCH_5_9:
                s = sch_5_9;
                break;
            case ScheduleViewId.SCH_5_10:
                s = sch_5_10;
                break;
            case ScheduleViewId.SCH_5_11:
                s = sch_5_11;
                break;
            case ScheduleViewId.SCH_5_12:
                s = sch_5_12;
                break;
            case ScheduleViewId.SCH_5_13:
                s = sch_5_13;
                break;

            case ScheduleViewId.SCH_6_1:
                s = sch_6_1;
                break;
            case ScheduleViewId.SCH_6_2:
                s = sch_6_2;
                break;
            case ScheduleViewId.SCH_6_3:
                s = sch_6_3;
                break;
            case ScheduleViewId.SCH_6_4:
                s = sch_6_4;
                break;
            case ScheduleViewId.SCH_6_5:
                s = sch_6_5;
                break;
            case ScheduleViewId.SCH_6_6:
                s = sch_6_6;
                break;
            case ScheduleViewId.SCH_6_7:
                s = sch_6_7;
                break;
            case ScheduleViewId.SCH_6_8:
                s = sch_6_8;
                break;
            case ScheduleViewId.SCH_6_9:
                s = sch_6_9;
                break;
            case ScheduleViewId.SCH_6_10:
                s = sch_6_10;
                break;
            case ScheduleViewId.SCH_6_11:
                s = sch_6_11;
                break;
            case ScheduleViewId.SCH_6_12:
                s = sch_6_12;
                break;
            case ScheduleViewId.SCH_6_13:
                s = sch_6_13;
                break;

            case ScheduleViewId.SCH_7_1:
                s = sch_7_1;
                break;
            case ScheduleViewId.SCH_7_2:
                s = sch_7_2;
                break;
            case ScheduleViewId.SCH_7_3:
                s = sch_7_3;
                break;
            case ScheduleViewId.SCH_7_4:
                s = sch_7_4;
                break;
            case ScheduleViewId.SCH_7_5:
                s = sch_7_5;
                break;
            case ScheduleViewId.SCH_7_6:
                s = sch_7_6;
                break;
            case ScheduleViewId.SCH_7_7:
                s = sch_7_7;
                break;
            case ScheduleViewId.SCH_7_8:
                s = sch_7_8;
                break;
            case ScheduleViewId.SCH_7_9:
                s = sch_7_9;
                break;
            case ScheduleViewId.SCH_7_10:
                s = sch_7_10;
                break;
            case ScheduleViewId.SCH_7_11:
                s = sch_7_11;
                break;
            case ScheduleViewId.SCH_7_12:
                s = sch_7_12;
                break;
            case ScheduleViewId.SCH_7_13:
                s = sch_7_13;
                break;
        }

        return s;
    }

}
