package com.trekup.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.trekup.domain.Account;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Locale locale, Model model, Account account) throws Exception {
		return "trekup";
	}
}
