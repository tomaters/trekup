package com.trekup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trekup.domain.Account;
import com.trekup.mapper.AccountMapper;
import com.trekup.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper mapper;

	@Override
	public Account readByUsername(String username) {
		return readByUsername(username);
	}
}
