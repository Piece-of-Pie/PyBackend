package com.pieceofpie.py.enums;

import lombok.Getter;

@Getter
public enum AccountTypeEnum implements BaseEnum {
    Student(0),
    Teacher(1);

    private Integer code;
    AccountTypeEnum(int code) {
        this.code = code;
    }
}
