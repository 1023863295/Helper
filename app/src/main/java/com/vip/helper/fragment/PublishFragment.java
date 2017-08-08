package com.vip.helper.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vip.helper.R;
import com.vip.helper.view.StateLayoutView;

/**
 * 作者：liuliang
 * 时间 2017/7/5 23:09
 * 邮箱：liang.liu@zmind.cn
 */
public class PublishFragment extends Fragment {
    private View view;

    private Activity mActivity;
    private StateLayoutView stateLayoutView;

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity =  activity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity)context;
    }

    public Activity getmActivity() {
        return mActivity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (stateLayoutView == null){
            // 说明这个Fragemnt的onCreateView方法是第一次执行
            view = inflater.inflate(R.layout.fragment_publish, container, false);
            stateLayoutView = stateLayoutView.newInstance(mActivity, view);
            initView();
        }else{
            ViewGroup parent = (ViewGroup) stateLayoutView.getParent();
            if (parent != null) {
                parent.removeView(stateLayoutView);
            }
        }
        return stateLayoutView;
    }

    private void initView(){
        stateLayoutView.showLoadingView();
    }
}
