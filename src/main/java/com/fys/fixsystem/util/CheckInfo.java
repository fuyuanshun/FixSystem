package com.fys.fixsystem.util;

import java.util.regex.Pattern;

/**
 * 检查前台传入的信息的辅助类
 */
public class CheckInfo {

    /**
     * 判断一个字符串是否是null值或者空串，如果是则返回true，否则返回false
     * @param str
     * @return
     */
    public static boolean isNull(String str) {
        if (null != str && !str.equals("")) {
            return false;
        }
        return true;
    }

    /**
     * 判断一个字符串数组里或者一个字符串是否有空字符串或者空值，如果有则返回true, 否则返回false
     * @param strs
     * @return
     */
    public static boolean isNull(String... strs) {
        boolean flag = false;
        for (String str : strs) {
            //如果为空，将标记设置为true
            if (isNull(str)) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 判断一个字符串是否是手机号码格式
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone) {
        if (Pattern.matches("^1[3578][0-9]{9}$", phone)) {
            return true;
        }
        return false;
    }
}