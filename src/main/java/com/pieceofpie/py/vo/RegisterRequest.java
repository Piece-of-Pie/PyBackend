package com.pieceofpie.py.vo;

import com.pieceofpie.py.enums.AccountTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RegisterRequest {
    @NotBlank(message = "姓名不能为空")
    private String name;
    @Size(min = 8, message = "密码不能小于 8 位")
    @NotBlank(message = "密码不能为空")
    private String password;
    @Size(min = 8, message = "密码不能小于 8 位")
    @NotBlank(message = "确认密码不能为空")
    private String confirmPassword;
    private AccountTypeEnum type;
}
