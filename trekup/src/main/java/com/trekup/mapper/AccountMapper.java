package com.trekup.mapper;

import com.trekup.domain.Account;

public interface AccountMapper {

	public Account readByUsername(String username);

}
