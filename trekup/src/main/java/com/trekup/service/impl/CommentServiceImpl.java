package com.trekup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trekup.domain.Comment;
import com.trekup.mapper.CommentMapper;
import com.trekup.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper mapper;
	
	@Override
	public Comment getComment(int comments_no) throws Exception {
		return mapper.getComment(comments_no);
	}

	@Override
	public List<Comment> getCommentList() throws Exception {
		return mapper.getCommentList();
	}

	@Override
	public void insertComment(Comment comment) throws Exception {
		mapper.insertComment(comment);
	}

	@Override
	public void deleteComment(int comments_no) throws Exception {
		mapper.deleteComment(comments_no);
	}

	
}
