package com.trekup.common.global;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.java.Log;

@Log
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({Exception.class, IOException.class, SQLException.class})
	public String handleException(Exception e, Model model) {
		log.info("GlobalExceptionHandler: " + e.toString());
		String errorMessage = "An error has occurred. Please try again";
		model.addAttribute("errorMessage", errorMessage);
		model.addAttribute("errorContent", e.getMessage());
		// throw error page
		return "error/error";
	}
	
}
