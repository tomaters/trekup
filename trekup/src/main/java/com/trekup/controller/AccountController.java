package com.trekup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.trekup.domain.Account;
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
	
	@GetMapping("/signup")
	public String signup(String error, String logout) {
		return "account/signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@Validated Account account, Model model, BindingResult result, RedirectAttributes rttr) throws Exception {
		String inputPassword = account.getPassword();
		account.setPassword(passwordEncoder.encode(inputPassword));

		accountService.signup(account);
		rttr.addFlashAttribute("username", account.getUsername());

		return "redirect:/account/login";
	}
	
	@GetMapping("/loginFail")
	public String loginFail(String error, String logout) {
		return "/";
	}	
}