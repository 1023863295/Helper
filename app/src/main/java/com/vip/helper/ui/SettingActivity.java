package com.vip.helper.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.vip.helper.R;
import com.vip.helper.base.BaseAty;
import com.vip.helper.global.Constants;
import com.vip.helper.tool.SharedPreferencesHelper;

public class SettingActivity extends BaseAty implements View.OnClickListener{

    private ImageView imgBack;
    private TextView textTitle;

    private Button btnLoginOut;

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutView() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView() {
        imgBack = (ImageView)findViewById(R.id.top_title_img_back);
        imgBack.setOnClickListener(this);
        textTitle = (TextView)findViewById(R.id.top_title_text_title);
        textTitle.setText("设置");

        btnLoginOut = (Button)findViewById(R.id.setting_btn_loginout);
        btnLoginOut.setOnClickListener(this);

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
            case R.id.setting_btn_loginout:
                SharedPreferencesHelper.remove(Constants.USER_ID);
                Intent intentRegister = new Intent(this,LoginAty.class);
                startActivity(intentRegister);
                finish();
                break;
        }
    }
}
