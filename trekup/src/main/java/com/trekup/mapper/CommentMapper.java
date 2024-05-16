package com.trekup.mapper;

import java.util.List;

import com.trekup.domain.Comment;

public interface CommentMapper {

	public Comment getComment(int comment_no) throws Exception;
	
	public List<Comment> getCommentList() throws Exception;
	
	public void insertComment(Comment comment) throws Exception;
	
	public void deleteComment(int comment_no) throws Exception;
}