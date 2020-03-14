package com.fei.sstudy.ui.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fei.sstudy.R;
import com.fei.sstudy.util.StatusBarUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {


    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        changeStatusBar();

        return view;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        changeStatusBar();
    }

    /**
     * 改变状态栏颜色
     */
    private void changeStatusBar(){
        StatusBarUtils.setWindowStatusBarColor(getActivity(),getResources().getColor(R.color.color_shedule_system));
        StatusBarUtils.setWindowTextLightBarColor(getActivity());
    }
}
