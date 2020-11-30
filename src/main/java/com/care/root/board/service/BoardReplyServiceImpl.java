package com.care.root.board.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.board.dao.BoardDAO;
@Service
public class BoardReplyServiceImpl implements BoardReplyService{
	@Autowired
	BoardDAO dao;
	//답글 등록
	public void replyBrdOk(HttpServletRequest req) {
		dao.replyBrdOk(req);
	}
}
