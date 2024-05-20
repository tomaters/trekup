package com.trekup.common.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// extend built-in Spring Security class to handle successful authentication requests
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		// getPrincipal() extracts the principal (user) object from Authentication object
		User customAccount = (User) authentication.getPrincipal();
		// after extracting, invoke superclass method. have option to add custom behavior here, such as logging, session management, or redirection
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
