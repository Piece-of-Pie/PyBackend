package com.pieceofpie.py.controller;

import com.pieceofpie.py.enums.AccountTypeEnum;
import com.pieceofpie.py.service.StudentService;
import com.pieceofpie.py.service.TeacherService;
import com.pieceofpie.py.vo.AccountVo;
import com.pieceofpie.py.vo.LoginRequest;
import com.pieceofpie.py.vo.RegisterRequest;
import com.pieceofpie.py.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("account")
public class AccountController {
  @Autowired
  private StudentService studentService;
  @Autowired
  private TeacherService teacherService;

  @PostMapping("login")
  public ResponseVo<AccountVo> login(@Validated @RequestBody LoginRequest request){
    if (request.getType() == AccountTypeEnum.Student)
      return ResponseVo.success(studentService.login(request.getNo(), request.getPassword()));
    else return ResponseVo.success(teacherService.login(request.getNo(), request.getPassword()));
  }

  @PostMapping("register")
  public ResponseVo<AccountVo> register(@Validated @RequestBody RegisterRequest request){
    if (request.getType() == AccountTypeEnum.Student)
      return ResponseVo.success(studentService.register(request));
    else return ResponseVo.success(teacherService.register(request));
  }
}
