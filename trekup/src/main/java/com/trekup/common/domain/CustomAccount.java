package com.trekup.common.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.trekup.domain.Account;

import lombok.Data;

// create custom user account objects that integrate with Spring Security
@Data
public class CustomAccount extends User {

	// ensure deserialization compatibility. assign arbitrary number 1L for 
	private static final long serialVersionUID = 1L;
	
	private Account account; 
	
	public CustomAccount(String username, String password, Collection<? extends GrantedAuthority > authorities) {
		super(username, password, authorities);
	}
	
	// change Member type to Spring Security UserDetails type
	public CustomAccount(Account account) {
		super(account.getUsername(), account.getPassword(), account.getAuthList().stream().map(auth 
				-> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		this.account = account;
	}
	
	public Account getAccount() {
		return account;
	}
}
