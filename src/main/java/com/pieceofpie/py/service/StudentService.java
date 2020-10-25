package com.pieceofpie.py.service;

import com.pieceofpie.py.model.CoursePo;
import com.pieceofpie.py.model.MemorandumPo;
import com.pieceofpie.py.model.StudentPo;
import com.pieceofpie.py.vo.AccountVo;
import com.pieceofpie.py.vo.LoginRequest;
import com.pieceofpie.py.vo.RegisterRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    AccountVo register(RegisterRequest request);
    AccountVo login(long studentNo, String password);
    List<CoursePo> queryCoursesByStudentId(long studentId);
    boolean joinCourse(long studentId, long courseId);
    MemorandumPo addMemorandum(long studentId, String content);
}
