package com.example.hrworkers.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.hrworkers.exceptions.WorkerNotFoundException;
import com.example.hrworkers.utils.ApiErrors;

@RestControllerAdvice
public class ApplicationControllerAdvice {
	
	private String mensagemErro;
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors workerNotFoundExceptionHandle(WorkerNotFoundException ex) {
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
