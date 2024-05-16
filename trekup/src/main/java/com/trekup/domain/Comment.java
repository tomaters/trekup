package com.trekup.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Comment {

	private int comments_no;
	private String username;
	private Date comments_date;
	private String comments_text;
	
}
