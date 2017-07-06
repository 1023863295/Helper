package com.vip.helper.tool;

import android.text.TextUtils;

/**
 * Created by liuliang on 2017/7/6.
 */

public class StringUtil {
    public static boolean isEmpty(String str) {
        if (TextUtils.isEmpty(str) || "null".equals(str)|| (str != null && "".equals(str.trim()))) {
            return true;
        }
        return false;
    }
}
