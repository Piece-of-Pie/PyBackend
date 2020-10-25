package com.pieceofpie.py.service.impl;

import com.pieceofpie.py.common.Constants;
import com.pieceofpie.py.enums.AccountTypeEnum;
import com.pieceofpie.py.exception.BusinessException;
import com.pieceofpie.py.exception.LoginNotPassException;
import com.pieceofpie.py.exception.ParameterException;
import com.pieceofpie.py.model.TeacherPo;
import com.pieceofpie.py.repository.TeacherMapper;
import com.pieceofpie.py.service.TeacherService;
import com.pieceofpie.py.vo.AccountVo;
import com.pieceofpie.py.vo.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class TeacherServiceImpl implements TeacherService {
  @Autowired
  private TeacherMapper teacherMapper;

  @Override
  public AccountVo login(long no, String password) {
    TeacherPo teacher = teacherMapper.getByTeacherNo(no / Constants.ACCOUNT_NO_DELIMITER, no % Constants.ACCOUNT_NO_DELIMITER);
    if (teacher != null && teacher.getPassword().equals(password))
      return buildAccountVo(teacher);
    else throw new LoginNotPassException("工号或密码不正确！");
  }

  @Override
  public AccountVo register(RegisterRequest request) {
    if (!request.getPassword().equals(request.getConfirmPassword())) throw new ParameterException("两次输入密码不一致！");
    TeacherPo teacher = createTeacher(request);
    teacherMapper.insert(teacher);
    return buildAccountVo(teacher);
  }

  private TeacherPo createTeacher(RegisterRequest request) {
    TeacherPo teacher = new TeacherPo();
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    teacher.setYear(calendar.get(Calendar.YEAR));
    long maxNum = getNextNo(year);
    teacher.setTeacherNo(maxNum);
    teacher.setName(request.getName());
    teacher.setPassword(request.getPassword());
    return teacher;
  }

  private Long getNextNo(int year) {
    Long maxNum = teacherMapper.getLastNumOfTheYear(year);
    if (maxNum == null) {
      return Constants.ACCOUNT_NO_DELIMITER / 10;
    } else return maxNum + 1;
  }

  private AccountVo buildAccountVo(TeacherPo teacher) {
    AccountVo accountVo = new AccountVo();
    accountVo.setAccountType(AccountTypeEnum.Teacher);
    accountVo.setId(teacher.getId());
    accountVo.setName(teacher.getName());
    accountVo.setNo(teacher.getYear() * Constants.ACCOUNT_NO_DELIMITER + teacher.getTeacherNo());
    return accountVo;
  }
}
