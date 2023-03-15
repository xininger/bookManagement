package com.aaa.util;

import com.aaa.exception.TipException;

import javax.servlet.http.HttpServletRequest;

public class MyToolUtil {

    public static boolean checkEmpty(Object obj, String msg, HttpServletRequest request) {
        if (null == obj) {
            request.getSession().setAttribute("bmsg", msg+"没有输入！");
//            throw TipException.makeFail(appendEmptyMsg(msg));
            return true;
        }
        return false;
    }

    public static void objIsExist(Object obj, String msg) {
        if (null != obj) {
            throw TipException.makeFail(msg);
        }
    }

    private static String appendEmptyMsg(String msg) {
        return msg + "is empty";
    }
}
