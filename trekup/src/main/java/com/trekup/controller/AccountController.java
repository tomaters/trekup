package com.trekup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trekup.service.AccountService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/login")
	public String login(String error, String logout) {
		return "account/login";
	}
	
	@GetMapping("/loginFail")
	public String loginFail(String error, String logout) {
		return "/";
	}	
}