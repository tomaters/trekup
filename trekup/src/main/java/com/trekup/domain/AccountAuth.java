package com.trekup.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// AccountAuth represents the user authorities and roles; contains information on what users can and cannot do
@Getter
@Setter
@ToString
public class AccountAuth implements Serializable {

	private static final long serialVersionUID = 3L;
	
	private String username;
	private String auth;
}