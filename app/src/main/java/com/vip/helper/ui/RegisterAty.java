package com.vip.helper.ui;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.vip.helper.R;
import com.vip.helper.base.BaseAty;
import com.vip.helper.bean.CommonResult;
import com.vip.helper.bean.MessageBean;
import com.vip.helper.global.Constants;
import com.vip.helper.tool.GsonUtils;
import com.vip.helper.tool.OkhttpUtil;
import com.vip.helper.tool.StringUtil;
import com.vip.helper.tool.ToastUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 作者：liuliang
 * 时间 2017/7/3 22:41
 * 邮箱：liang.liu@zmind.cn
 */
public class RegisterAty extends BaseAty implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;

    private EditText editLoginName;
    private EditText editPassword;
    private EditText editVerifyCode;
    protected TextView textGetCode;

    private String loginName;
    private String password;
    private String verifyCode;
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

        editLoginName = (EditText)findViewById(R.id.register_edit_phone);
        editPassword = (EditText)findViewById(R.id.register_edit_password);
        editVerifyCode = (EditText)findViewById(R.id.register_edit_verify);

        textGetCode = (TextView)findViewById(R.id.register_text_get_code);
        textGetCode.setOnClickListener(this);


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
            case R.id.register_text_get_code:
                getCode("13476183516");
                break;
            case R.id.register_btn_register:
                loginName = editLoginName.getText().toString().trim();
                password = editPassword.getText().toString().trim();
                verifyCode = editVerifyCode.getText().toString().trim();
                register(loginName,password,verifyCode);
                break;
        }
    }

    private void  getCode(String phoneNumber){
        if (!StringUtil.isPhone(phoneNumber)){
            ToastUtil.showLongToast(this,"请输入争取手机号");
            return;
        }
        OkHttpClient okHttpClient = OkhttpUtil.getInstance().getOkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("loginname", phoneNumber)
                .build();
        Request request = new Request.Builder()
                .url(Constants.GET_VERIFY)
                .post(formBody)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                Log.i("test",s);
                CommonResult<MessageBean> jsonData = GsonUtils
                        .convertBeanFromJson(s,
                                (new TypeToken<CommonResult<MessageBean>>(){
                }));

                if (jsonData.header.rspCode.equals("0000")){

                }
            }
        });
    }

    //点击注册之前检测输入是否合法
    private boolean check(String loginname,String password,String verifyCode){
        if (!StringUtil.isPhone(loginname)){
            ToastUtil.showLongToast(this,"请输入争取手机号");
            return false;
        }else if(password.length()<6 || password.length() > 16){
            ToastUtil.showLongToast(this,"请输入密码");
            return false;
        }else if(verifyCode.length()==0){
            ToastUtil.showLongToast(this,"验证码");
            return false;
        }
        return true;
    }

    //注冊
    private void register(String loginname,String password,String verifyCode){
        OkHttpClient okHttpClient = OkhttpUtil.getInstance().getOkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("loginname", loginname)
                .add("password", password)
                .add("verifyCode", verifyCode)
                .build();
        Request request = new Request.Builder()
                .url(Constants.REGISTER_URL)
                .post(formBody)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }
}
