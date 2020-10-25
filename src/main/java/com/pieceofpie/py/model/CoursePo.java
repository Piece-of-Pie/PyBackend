package com.pieceofpie.py.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoursePo extends BasePo {
    private String name;
    private long teacher_id;
}
