package com.vip.helper.ui;

import android.content.Intent;

import com.vip.helper.R;
import com.vip.helper.base.BaseAty;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 作者：liuliang
 * 时间 2017/7/3 21:53
 * 邮箱：liang.liu@zmind.cn
 */
public class WelcomeAty extends BaseAty {
    private Timer timer;
    private TimerTask timerTask;

    @Override
    protected void initData() {
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeAty.this,HomeAty.class);
                startActivity(intent);
            }
        };
    }

    @Override
    protected int getLayoutView() {
        return R.layout.aty_welcome;
    }

    @Override
    protected void initView() {
        timer.schedule(timerTask,3000);
    }

    @Override
    protected void afterViewInit() {

    }
}
