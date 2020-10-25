package com.pieceofpie.py.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TeacherPo extends BasePo {
    private String name;
    private long teacherNo;
    private int year;
    private String password;
}
