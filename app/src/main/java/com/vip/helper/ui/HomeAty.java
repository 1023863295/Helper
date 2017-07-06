package com.vip.helper.ui;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.vip.helper.R;
import com.vip.helper.base.BaseAty;
import com.vip.helper.fragment.FindFragment;
import com.vip.helper.fragment.MainFragment;
import com.vip.helper.fragment.MessageFragment;
import com.vip.helper.fragment.MineFragment;
import com.vip.helper.fragment.PublishFragment;
import com.vip.helper.tool.SharedPreferencesHelper;
import com.vip.helper.tool.StringUtil;

/**
 * 作者：liuliang
 * 时间 2017/7/3 22:00
 * 邮箱：liang.liu@zmind.cn
 */
public class HomeAty extends BaseAty implements View.OnClickListener ,RadioGroup.OnCheckedChangeListener{
    private ImageView imgBack;
    private TextView textTitle;


    private RadioGroup radioGroupBottom;
    private RadioButton rbMain;
    private RadioButton rbFind;
    private RadioButton rbPublish;
    private  RadioButton rbMessage;
    private  RadioButton rbMine;

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


        radioGroupBottom = (RadioGroup)findViewById(R.id.home_bottom_bar);
        radioGroupBottom.setOnCheckedChangeListener(this);
        rbMain = (RadioButton)findViewById(R.id.home_bottom_main);
        rbMain.setOnClickListener(this);
        rbFind = (RadioButton)findViewById(R.id.home_bottom_find);
        rbFind.setOnClickListener(this);
        rbPublish = (RadioButton)findViewById(R.id.home_bottom_publish);
        rbPublish.setOnClickListener(this);
        rbMessage = (RadioButton)findViewById(R.id.home_bottom_message);
        rbMessage.setOnClickListener(this);
        rbMine = (RadioButton)findViewById(R.id.home_bottom_mine);
        rbMine.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId){
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
                if (StringUtil.isEmpty(SharedPreferencesHelper.getData(this,"user_name","")+"")){
                    //未登陆，跳转至登陆页面
                    Intent intentLogin = new Intent(this,LoginAty.class);
                    startActivity(intentLogin);
                    rbMine.setChecked(false);
                }else{
                    setFragment(mineFragment);
                    textTitle.setText("我的");
                }
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
