package com.trekup.mapper;

import com.trekup.domain.Account;
import com.trekup.domain.AccountAuth;

public interface AccountMapper {

	public Account readByUsername(String username);
	
	public void signup(Account account) throws Exception;
	
	public void signupAuth(AccountAuth accountAuth) throws Exception;
}
