package com.vip.helper.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.vip.helper.R;
import com.vip.helper.ui.OrderListAty;
import com.vip.helper.ui.SettingActivity;
import com.vip.helper.ui.UserInfoAty;

/**
 * 作者：liuliang
 * 时间 2017/7/3 23:06
 * 邮箱：liang.liu@zmind.cn
 */
public class MineFragment extends Fragment implements View.OnClickListener{
    private View view;


    private RelativeLayout rlVipInfo;


    private RelativeLayout rlMyWant;
    private RelativeLayout rlMyReplace; //代购
    private RelativeLayout rlMyReplace2;
    private RelativeLayout rlMyStore;
    private RelativeLayout rlSetting;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mycenter_layout, container, false);
        initView();
        return view;
    }

    private void initView(){

        rlVipInfo = (RelativeLayout)view.findViewById(R.id.fragment_mycenter_rl_vip);
        rlVipInfo.setOnClickListener(this);

        rlMyWant  = (RelativeLayout)view.findViewById(R.id.fragment_mycenter_rl_want);
        rlMyWant.setOnClickListener(this);
        rlMyReplace = (RelativeLayout)view.findViewById(R.id.fragment_mycenter_rl_replace);
        rlMyReplace.setOnClickListener(this);
        rlMyStore = (RelativeLayout)view.findViewById(R.id.fragment_mycenter_rl_store);
        rlMyStore.setOnClickListener(this);
        rlSetting = (RelativeLayout)view.findViewById(R.id.fragment_mycenter_rl_setting);
        rlSetting.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.fragment_mycenter_rl_vip:
               Intent intentUserInfo = new Intent(getActivity(), UserInfoAty.class);
               startActivity(intentUserInfo);
               break;
           case R.id.fragment_mycenter_rl_want:
               Intent intentWant = new Intent(getActivity(), OrderListAty.class);
               intentWant.putExtra("type",0);
               startActivity(intentWant);
               break;
           case R.id.fragment_mycenter_rl_replace:
               Intent intentReplace = new Intent(getActivity(), OrderListAty.class);
               intentReplace.putExtra("type",1);
               startActivity(intentReplace);
               break;
           case R.id.fragment_mycenter_rl_store:
               Intent intentStore = new Intent(getActivity(), OrderListAty.class);
               intentStore.putExtra("type",2);
               startActivity(intentStore);
               break;
           case R.id.fragment_mycenter_rl_setting:
               Intent intent = new Intent(getActivity(), SettingActivity.class);
               startActivity(intent);
               break;
       }
    }
}
