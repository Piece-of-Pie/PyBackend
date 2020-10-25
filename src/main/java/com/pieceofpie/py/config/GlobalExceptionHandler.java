package com.pieceofpie.py.config;

import com.pieceofpie.py.enums.ResponseCodeEnum;
import com.pieceofpie.py.exception.BusinessException;
import com.pieceofpie.py.exception.LoginNotPassException;
import com.pieceofpie.py.exception.ParameterException;
import com.pieceofpie.py.vo.ResponseVo;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LoginNotPassException.class)
    public ResponseVo<?> handleBusinessException(LoginNotPassException ex){
        return ResponseVo.error(ResponseCodeEnum.AUTHENTICATION_ERROR, ex.getMessage());
    }
    @ExceptionHandler(ParameterException.class)
    public ResponseVo<?> handleBusinessException(ParameterException ex){
        return ResponseVo.error(ResponseCodeEnum.PARAM_ERROR, ex.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseVo<?> handleBusinessException(BusinessException be){
        return ResponseVo.error(be.getMessage());
    }
    /**
     * 方法参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseVo handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseVo.error(ResponseCodeEnum.PARAM_ERROR, e.getBindingResult().getFieldError().getDefaultMessage());
    }

    /**
     * ValidationException
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseVo handleValidationException(ValidationException e) {
        return ResponseVo.error(ResponseCodeEnum.PARAM_ERROR, e.getCause().getMessage());
    }

    /**
     * ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseVo handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseVo.error(ResponseCodeEnum.PARAM_ERROR, e.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseVo handlerNoFoundException(Exception e) {
        return ResponseVo.error(ResponseCodeEnum.NOT_FOUND_ERROR);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseVo handleDuplicateKeyException(DuplicateKeyException e) {
        return ResponseVo.error(ResponseCodeEnum.DUPLICATE_KEY_ERROR);
    }
    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseVo<?> errorHandler(Exception ex) {
        return ResponseVo.error(ex.getMessage());
    }
}
