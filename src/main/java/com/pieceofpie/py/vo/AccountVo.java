package com.pieceofpie.py.vo;

import com.pieceofpie.py.enums.AccountTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountVo {
    private long id;
    private String name;
    private long no;
    private AccountTypeEnum accountType;
}
