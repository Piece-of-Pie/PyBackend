package com.pieceofpie.py.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public abstract class BasePo {
    private long id;
    private Date createTime;
    private Date updateTime;
}
