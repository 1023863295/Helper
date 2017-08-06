package com.vip.helper.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * 作者：liuliang
 * 时间 2017/7/16 09:15
 * 邮箱：liang.liu@zmind.cn
 */
public class CommonResult<E>{
    @Expose()
    @SerializedName(value = "header")
    public Header header;

    @Expose()
    @SerializedName(value = "Data")
    public E body;

}
