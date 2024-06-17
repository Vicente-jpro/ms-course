package com.example.hrusers.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.hrusers.exceptions.UserNotFoundException;
import com.example.hrusers.utils.ApiErrors;

@RestControllerAdvice
public class ApplicationControllerAdvice {
	
	private String mensagemErro;
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors UserNotFoundExceptionHandle(UserNotFoundException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors validateFieldsHandle( MethodArgumentNotValidException ex ) {
		List<String> erros = ex.getBindingResult()
		  .getAllErrors()
		  .stream()
		  .map( erro -> erro.getDefaultMessage()
				).collect( Collectors.toList());
		
		return new ApiErrors(erros);
	}
}
