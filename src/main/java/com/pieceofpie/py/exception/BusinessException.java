package com.pieceofpie.py.exception;

import com.pieceofpie.py.enums.ResponseCodeEnum;

public class BusinessException extends RuntimeException {
    private int code;
    private String message;

    public BusinessException(String message) {
        this.code = ResponseCodeEnum.INTERNAL_ERROR.getCode();
        this.message = message;
    }

    public BusinessException(String message, String message1) {
        super(message);
        this.code = ResponseCodeEnum.INTERNAL_ERROR.getCode();
        this.message = message1;
    }

    public BusinessException(String message, Throwable cause, String message1) {
        super(message, cause);
        this.code = ResponseCodeEnum.INTERNAL_ERROR.getCode();
        this.message = message1;
    }

    public BusinessException(Throwable cause, String message) {
        super(cause);
        this.code = ResponseCodeEnum.INTERNAL_ERROR.getCode();
        this.message = message;
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = ResponseCodeEnum.INTERNAL_ERROR.getCode();
        this.message = message1;
    }
}
