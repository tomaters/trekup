package com.trekup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trekup.domain.Comment;
import com.trekup.service.CommentService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@GetMapping("/getComment")
	public String getComment(@RequestParam("comment_no") int comment_no, Model model) throws Exception {
		log.info("/getComment");
		Comment comment = commentService.getComment(comment_no); 
		model.addAttribute("comment", comment);
		// use to forward to a separate .jsp page
		return "/";
	}
	
	@GetMapping("/getCommentList")
	public String getCommentList(Model model) throws Exception {
		List<Comment> commentList = commentService.getCommentList();
		model.addAttribute("commentList", commentList);
		for(Comment comment : commentList) {
			log.info("/getCommentList: " + comment.toString());
		}
		return "trekup";
	}
	
	@PostMapping("/insertComment")
	public String insertComment(Comment comment) throws Exception {
		log.info("/insertComment");
		commentService.insertComment(comment);
		// use to redirect to a separate .jsp page
		return "redirect:/";
	}
	
	@PostMapping("/deleteComment")
	public void deleteComment(@RequestParam("comment_no") int comment_no) throws Exception {
		log.info("/deleteComment");
		commentService.deleteComment(comment_no);
	}
	
}
