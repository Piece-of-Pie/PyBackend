package com.pieceofpie.py.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentPo extends BasePo {
    private String name;
    private int year;
    private long studentNo;
    private String password;
}
