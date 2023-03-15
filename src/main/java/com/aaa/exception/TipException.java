package com.aaa.exception;

import com.sun.org.apache.xpath.internal.objects.XString;
import lombok.Data;

/**
 * 封装运行时异常
 */
@Data
public class TipException extends RuntimeException {
    private String errDesc;

    public TipException() {
    }

    public TipException(String message) {
        super(message);
    }

    public TipException(String message, Throwable cause) {
        super(message, cause);
    }

    public TipException(Throwable cause) {
        super(cause);
    }

    public static TipException makeFail(String errDesc) {
        return new TipException(errDesc);
    }
}
