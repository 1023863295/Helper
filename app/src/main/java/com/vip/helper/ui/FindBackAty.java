package com.vip.helper.ui;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.vip.helper.R;
import com.vip.helper.base.BaseAty;

/**
 * 作者：liuliang
 * 时间 2017/7/3 23:00
 * 邮箱：liang.liu@zmind.cn
 * 找回密码
 */
public class FindBackAty extends BaseAty implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;

    private Button btnYes;

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutView() {
        return R.layout.aty_findback_layout;
    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.top_title_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.top_title_text_title);
        textTitle.setText("找回密码");

        btnYes = (Button)findViewById(R.id.findback_btn_yes);
        btnYes.setOnClickListener(this);
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
            case R.id.findback_btn_yes:
                break;
        }

    }
}
