package com.crow.handler;

import com.crow.model.ResultResponse;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
 
	/**
	 * 处理Validated校验异常
	 * <p>
	 * 注: 常见的ConstraintViolationException异常， 也属于ValidationException异常
	 *
	 * @param e
	 *         捕获到的异常
	 * @return 返回给前端的data
	 */
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = {BindException.class, ValidationException.class, MethodArgumentNotValidException.class})
	public ResultResponse handleParameterVerificationException(Exception e) {
		log.error(" handleParameterVerificationException has been invoked", e);
		String msg = null;
		if (e instanceof MethodArgumentNotValidException) {
			BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
			// getFieldError获取的是第一个不合法的参数(P.S.如果有多个参数不合法的话)
			FieldError fieldError = bindingResult.getFieldError();
			if (fieldError != null) {
				msg = fieldError.getDefaultMessage();
			}
		} else if (e instanceof BindException) {
			// getFieldError获取的是第一个不合法的参数(P.S.如果有多个参数不合法的话)
			FieldError fieldError = ((BindException) e).getFieldError();
			if (fieldError != null) {
				msg = fieldError.getDefaultMessage();
			}
		} else if (e instanceof ConstraintViolationException) {
			/*
			 * ConstraintViolationException的e.getMessage()形如
			 *     {方法名}.{参数名}: {message}
			 *  这里只需要取后面的message即可
			 */
			msg = e.getMessage();
			if (msg != null) {
				int lastIndex = msg.lastIndexOf(':');
				if (lastIndex >= 0) {
					msg = msg.substring(lastIndex + 1).trim();
				}
			}
		} else {
			msg = "处理参数时异常";
		}
		log.info(msg);
		return new ResultResponse(msg);
	}
}