package com.vip.helper.ui;

import android.os.Handler;
import android.os.Message;
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
 * 时间 2017/7/3 23:00
 * 邮箱：liang.liu@zmind.cn
 * 找回密码
 */
public class FindBackAty extends BaseAty implements View.OnClickListener{
    private ImageView imgBack;
    private TextView textTitle;

    private Button btnGetCode;


    private EditText editLoginName;
    private EditText editPassword;
    private EditText editVerifyCode;
    private String loginName;
    private String password;
    private String verifyCode;

    private Button btnYes;

    public static final int GET_CODE_SUCCESS = 10;
    public static final int GET_CODE_FAILD = 20;
    public static final int FIND_BACK_SUCCESS = 30;
    public static final int FIND_BACK_FAILD = 40;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case GET_CODE_FAILD:
                    ToastUtil.showShortToast(FindBackAty.this,"请稍后重试");
                    break;
                case GET_CODE_SUCCESS:
                    paraseGetCodeResult(msg.obj.toString());
                    break;
                case FIND_BACK_FAILD:
                    ToastUtil.showShortToast(FindBackAty.this,"请稍后重试");
                    break;
                case FIND_BACK_SUCCESS:
                    paraseModifyResult(msg.obj.toString());
                    break;

            }
        }
    };

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


        editLoginName = (EditText)findViewById(R.id.findback_edit_phone);
        editPassword = (EditText)findViewById(R.id.findback_edit_password);
        editVerifyCode = (EditText)findViewById(R.id.findback_edit_verify);

        btnGetCode = (Button)findViewById(R.id.findback_btn_get_code);
        btnGetCode.setOnClickListener(this);

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
                loginName = editLoginName.getText().toString().trim();
                password = editPassword.getText().toString().trim();
                verifyCode = editVerifyCode.getText().toString().trim();
                modifyPassword(loginName,password,verifyCode);
                break;
            case R.id.findback_btn_get_code:
                getCode(editLoginName.getText().toString());
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
                handler.sendEmptyMessage(GET_CODE_FAILD);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                Log.i("test",s);
                Message message = handler.obtainMessage();
                message.obj = s;
                message.what = GET_CODE_SUCCESS;
                handler.sendMessage(message);

            }
        });
    }

    //解析获取验证码返回的结果
    private void paraseGetCodeResult(String result){
        CommonResult<MessageBean> jsonData = GsonUtils
                .convertBeanFromJson(result,
                        (new TypeToken<CommonResult<MessageBean>>(){
                        }));

        if (jsonData.header.rspCode.equals("0000")){
            ToastUtil.showShortToast(this,"发送成功");
        }else{
            ToastUtil.showShortToast(this,jsonData.header.rspDesc);
        }
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
    private void modifyPassword(String loginname,String password,String verifyCode){
        OkHttpClient okHttpClient = OkhttpUtil.getInstance().getOkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("loginName", loginname)
                .add("newPassword", password)
                .add("verifyCode", verifyCode)
                .build();
        Request request = new Request.Builder()
                .url(Constants.MODIFY_PASWORD_URL)
                .post(formBody)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.sendEmptyMessage(FIND_BACK_FAILD);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                Log.i("test",s);
                Message message = handler.obtainMessage();
                message.what = FIND_BACK_SUCCESS;
                message.obj = s;
                handler.sendMessage(message);

            }
        });
    }

    //解析修改密码返回的结果
    private void paraseModifyResult(String result){
        CommonResult<MessageBean> jsonData = GsonUtils
                .convertBeanFromJson(result,
                        (new TypeToken<CommonResult<MessageBean>>(){
                        }));

        if (jsonData.header.rspCode.equals("0000")){
            ToastUtil.showShortToast(this,"修改成功");
        }else{
            ToastUtil.showShortToast(this,jsonData.header.rspDesc);
        }
    }




}
