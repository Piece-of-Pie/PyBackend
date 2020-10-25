package com.pieceofpie.py.repository;

import com.pieceofpie.py.model.StudentPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentMapper {
    StudentPo getByStudentNo(@Param("year") long year, @Param("studentNo") long studentNo);
    int insert(StudentPo po);

    Long getLastNumOfTheYear(@Param("year") int year);
}
