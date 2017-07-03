package com.vip.helper.ui;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.vip.helper.R;
import com.vip.helper.base.BaseAty;

/**
 * 作者：liuliang
 * 时间 2017/7/3 22:41
 * 邮箱：liang.liu@zmind.cn
 */
public class RegisterAty extends BaseAty implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;

    private Button btnRigister;

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutView() {
        return R.layout.aty_register_layout;
    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.top_title_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.top_title_text_title);
        textTitle.setText("快速注册");


        btnRigister = (Button)findViewById(R.id.register_btn_register);
        btnRigister.setOnClickListener(this);
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
            case R.id.register_btn_register:
                break;
        }
    }
}
