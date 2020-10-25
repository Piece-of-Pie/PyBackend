package com.pieceofpie.py.vo;

import com.pieceofpie.py.enums.AccountTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;


@Getter
@Setter
public class LoginRequest {
  @Min(value = 0, message = "账号不能为空")
  @Digits(integer = 8, fraction = 0)
  private long no;
  @NotBlank(message = "密码不能为空")
  @Size(min = 8, message = "密码不能小于 8 位")
  private String password;
  private AccountTypeEnum type;
}
