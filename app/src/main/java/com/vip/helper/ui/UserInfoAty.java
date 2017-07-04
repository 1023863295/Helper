package com.vip.helper.ui;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.vip.helper.R;
import com.vip.helper.base.BaseAty;

/**
 * 作者：liuliang
 * 时间 2017/7/4 22:31
 * 邮箱：liang.liu@zmind.cn
 */
public class UserInfoAty extends BaseAty implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;
    private TextView textRight;

    private Button btnModify;


    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutView() {
        return R.layout.aty_user_info_layout;
    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.top_title_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.top_title_text_title);
        textTitle.setText("个人信息");
        textRight = (TextView)findViewById(R.id.top_title_right_more);
        textRight.setVisibility(View.VISIBLE);
        textRight.setText("取消修改");

        btnModify = (Button)findViewById(R.id.user_info_btn_modify_yes);
        btnModify.setOnClickListener(this);
    }

    @Override
    protected void afterViewInit() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.top_title_img_back:
                finish();
                break;
            case R.id.top_title_right_more:
                finish();
                break;
            case R.id.user_info_btn_modify_yes:
                break;
        }
    }
}
