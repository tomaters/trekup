package com.trekup.service;

import java.util.List;

import com.trekup.domain.Comment;

public interface CommentService {

	public Comment getComment(int comments_no) throws Exception;
	
	public List<Comment> getCommentList() throws Exception;
	
	public void insertComment(Comment comment) throws Exception;
	
	public void deleteComment(int comments_no) throws Exception;
}
