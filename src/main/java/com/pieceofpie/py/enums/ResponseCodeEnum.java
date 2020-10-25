package com.pieceofpie.py.enums;

import lombok.Getter;

@Getter
public enum ResponseCodeEnum implements BaseEnum {
    SUCCESS(0, "操作执行成功！"),

    PARAM_ERROR(4001, "参数有误！"),
    AUTHENTICATION_ERROR(4003, "用户验证失败"),
    NOT_FOUND_ERROR(4004, "路径不存在，请检查路径是否正确"),
    DUPLICATE_KEY_ERROR(4005, "数据重复，请检查后提交"),

    INTERNAL_ERROR(5000, "服务内部错误！");



    private Integer code;
    private String message;
    ResponseCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
