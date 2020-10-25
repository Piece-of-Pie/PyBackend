package com.pieceofpie.py.vo;

import com.pieceofpie.py.enums.ResponseCodeEnum;
import lombok.Getter;

@Getter
public class ResponseVo<T> {
    private int code;
    private String msg;
    private T data;

    public ResponseVo(int code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    private ResponseVo(String message) {
        this.code = ResponseCodeEnum.INTERNAL_ERROR.getCode();
        this.msg = message;
    }

    private ResponseVo(int code, String message) {
        this.code = code;
        this.msg = message;
    }

    public static <T> ResponseVo<T> success(T data) {
        return new ResponseVo(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMessage(), data);
    }

    public static ResponseVo<?> error(String message) {
        return new ResponseVo(message);
    }

    public static ResponseVo<?> error(ResponseCodeEnum codeEnum) {
        return new ResponseVo(codeEnum.getCode(), codeEnum.getMessage());
    }

    public static ResponseVo<?> error(ResponseCodeEnum codeEnum,String message) {
        return new ResponseVo(codeEnum.getCode(), message);
    }
}
