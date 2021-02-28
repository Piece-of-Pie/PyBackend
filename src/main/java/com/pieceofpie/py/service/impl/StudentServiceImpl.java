package com.pieceofpie.py.service.impl;

import com.pieceofpie.py.common.Constants;
import com.pieceofpie.py.enums.AccountTypeEnum;
import com.pieceofpie.py.exception.LoginNotPassException;
import com.pieceofpie.py.exception.ParameterException;
import com.pieceofpie.py.model.CoursePo;
import com.pieceofpie.py.model.MemorandumPo;
import com.pieceofpie.py.model.StudentPo;
import com.pieceofpie.py.repository.StudentMapper;
import com.pieceofpie.py.service.StudentService;
import com.pieceofpie.py.vo.AccountVo;
import com.pieceofpie.py.vo.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
  @Autowired
  private StudentMapper studentMapper;

  @Override
  public AccountVo register(RegisterRequest request) {
    if (!request.getPassword().equals(request.getConfirmPassword())) throw new ParameterException("两次输入密码不一致！");
    StudentPo student = createStudent(request);
    studentMapper.insert(student);
    return buildAccountVo(student);
  }

  private StudentPo createStudent(RegisterRequest request) {
    StudentPo student = new StudentPo();
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    student.setYear(calendar.get(Calendar.YEAR));
    Long maxNum = getNextNo(year);
    student.setStudentNo(maxNum);
    student.setName(request.getName());
    student.setPassword(request.getPassword());
    return student;
  }

  private Long getNextNo(int year) {
    Long maxNum = studentMapper.getLastNumOfTheYear(year);
    if (maxNum == null) {
      return Constants.ACCOUNT_NO_DELIMITER / 10;
    } else return maxNum + 1;
  }

  private AccountVo buildAccountVo(StudentPo student) {
    AccountVo accountVo = new AccountVo();
    accountVo.setAccountType(AccountTypeEnum.Student);
    accountVo.setId(student.getId());
    accountVo.setName(student.getName());
    accountVo.setNo(student.getYear() * Constants.ACCOUNT_NO_DELIMITER + student.getStudentNo());
    return accountVo;
  }

  @Override
  public AccountVo login(long studentNo, String password) {
    StudentPo student = studentMapper.getByStudentNo(studentNo / Constants.ACCOUNT_NO_DELIMITER, studentNo % (Constants.ACCOUNT_NO_DELIMITER * 10));
    if (student != null && student.getPassword().equals(password))
      return buildAccountVo(student);
    else throw new LoginNotPassException("学号或密码不正确！");
  }

  @Override
  public List<CoursePo> queryCoursesByStudentId(long studentId) {
    return null;
  }

  @Override
  public boolean joinCourse(long studentId, long courseId) {
    return false;
  }

  @Override
  public MemorandumPo addMemorandum(long studentId, String content) {
    return null;
  }
}
