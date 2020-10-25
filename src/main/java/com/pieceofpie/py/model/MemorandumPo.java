package com.pieceofpie.py.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemorandumPo extends BasePo{
    private String content;
    private long studentId;
}
