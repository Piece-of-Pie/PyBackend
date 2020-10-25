package com.pieceofpie.py.repository;

import com.pieceofpie.py.model.TeacherPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TeacherMapper {
    TeacherPo getByTeacherNo(@Param("year") long yaer, @Param("no") long no);

  int insert(TeacherPo teacher);

  Long getLastNumOfTheYear(int year);
}
