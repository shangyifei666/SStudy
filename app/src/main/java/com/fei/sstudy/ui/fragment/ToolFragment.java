package com.fei.sstudy.ui.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fei.sstudy.R;
import com.fei.sstudy.ui.CheckPlaceActivity;
import com.fei.sstudy.util.StatusBarUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToolFragment extends Fragment implements View.OnClickListener {

    private ImageView ivZixi;
    private TextView tvZixi;

    public ToolFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tool, container, false);
        changeStatusBar();

        initView(view);

        return view;
    }

    private void initView(View view){
        ivZixi = view.findViewById(R.id.iv_zixi);
        tvZixi = view.findViewById(R.id.tv_zixi);
        ivZixi.setOnClickListener(this);
        tvZixi.setOnClickListener(this);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        changeStatusBar();
    }

    private void changeStatusBar(){
        StatusBarUtils.setWindowStatusBarColor(getActivity(),getResources().getColor(R.color.color_tool_system));
        StatusBarUtils.setWindowTextDayBarColor(getActivity());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_zixi:
            case R.id.iv_zixi:
                Intent intent = new Intent(getContext(), CheckPlaceActivity.class);
                intent.putExtra("id",1);
                intent.putExtra("h",1);
                startActivityForResult(intent,0);
                break;
        }
    }
}
