package com.vip.helper.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vip.helper.R;
import com.vip.helper.base.BaseAty;
import com.vip.helper.fragment.FindFragment;
import com.vip.helper.fragment.MainFragment;
import com.vip.helper.fragment.MessageFragment;
import com.vip.helper.fragment.MineFragment;
import com.vip.helper.fragment.PublishFragment;

/**
 * 作者：liuliang
 * 时间 2017/7/3 22:00
 * 邮箱：liang.liu@zmind.cn
 */
public class HomeAty extends BaseAty implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;

    private TextView textMain;
    private TextView textFind;
    private TextView textPublish;
    private  TextView textMessage;
    private  TextView textMine;

    private Fragment currentFragment;
    private MainFragment mainFragment;
    private FindFragment findFragment;
    private PublishFragment publishFragment;
    private MessageFragment messageFragment;
    private MineFragment mineFragment;
    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void initData() {
        mainFragment = new MainFragment();
        findFragment = new FindFragment();
        publishFragment = new PublishFragment();
        messageFragment = new MessageFragment();
        mineFragment = new MineFragment();
    }

    @Override
    protected int getLayoutView() {
        return R.layout.aty_home_layout;
    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.top_title_img_back);
        imgBack.setVisibility(View.GONE);
        textTitle = (TextView)findViewById(R.id.top_title_text_title);
        textTitle.setText("首页");
    }

    @Override
    protected void afterViewInit() {
        currentFragment = mainFragment;
        fm=getSupportFragmentManager();
        ft=fm.beginTransaction();
        ft.replace(R.id.home_frame_container,mainFragment);
        ft.commit();

        textMain = (TextView)findViewById(R.id.home_bottom_main);
        textMain.setOnClickListener(this);
        textFind = (TextView)findViewById(R.id.home_bottom_find);
        textFind.setOnClickListener(this);
        textPublish = (TextView)findViewById(R.id.home_bottom_publish);
        textPublish.setOnClickListener(this);
        textMessage = (TextView)findViewById(R.id.home_bottom_message);
        textMessage.setOnClickListener(this);
        textMine = (TextView)findViewById(R.id.home_bottom_mine);
        textMine.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_bottom_main:
                setFragment(mainFragment);
                textTitle.setText("首页");
                break;
            case R.id.home_bottom_find:
                setFragment(findFragment);
                textTitle.setText("发现");
                break;
            case R.id.home_bottom_publish:
                setFragment(publishFragment);
                textTitle.setText("发布");
                break;
            case R.id.home_bottom_message:
                setFragment(messageFragment);
                textTitle.setText("消息");
                break;
            case R.id.home_bottom_mine:
                setFragment(mineFragment);
                textTitle.setText("我的");
                break;
        }
    }

    private void setFragment(Fragment fragment){
        if (currentFragment == fragment){
            return;
        }else{
            fm=getSupportFragmentManager();
            ft=fm.beginTransaction();
            ft.replace(R.id.home_frame_container,fragment);
            ft.commit();
            currentFragment = fragment;
        }
    }
}
