package com.trekup.common.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/* 
 implement Spring Securty PasswordEncoer interface
 create custom encoder that behaves like a no-op encoder (no encoding or hashing passwords)
 no-op encoders can be used for testing or debugging purposes. encode() will return raw password
*/
 public class CustomNoOpPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}
	
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// always return true, indicating that the raw password matches the encoded password
		return true;
	}
}
