package com.pieceofpie.py.service;

import com.pieceofpie.py.vo.AccountVo;
import com.pieceofpie.py.vo.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface TeacherService {
  AccountVo login(long no, String password);

  AccountVo register(RegisterRequest request);
}
