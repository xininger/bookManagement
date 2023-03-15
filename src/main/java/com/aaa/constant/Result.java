package com.aaa.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 向前端返回信息封装
 *
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    public static final int SUCCESS_CODE = 1;
    public static final int FAIL_CODE = 0;
    private Integer code; // 正常返回参数有code 前端通过这个值来判断请求是否成功,或失败
    //返回信息
    private String msg;
    //数据是否正常请求
    private boolean success;
    //具体返回的数据
    private T detail;
}
