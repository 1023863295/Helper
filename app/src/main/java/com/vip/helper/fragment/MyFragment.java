package com.vip.helper.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vip.helper.R;
import com.vip.helper.ui.UserInfoAty;

/**
 * 作者：liuliang
 * 时间 2017/7/3 23:06
 * 邮箱：liang.liu@zmind.cn
 */
public class MyFragment extends Fragment implements View.OnClickListener{
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mycenter_layout, container, false);
        initView();
        return view;
    }

    private void initView(){

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), UserInfoAty.class);
        startActivity(intent);
    }
}
