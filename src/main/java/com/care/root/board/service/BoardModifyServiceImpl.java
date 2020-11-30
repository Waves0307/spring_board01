package com.care.root.board.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.board.dao.BoardDAO;
@Service
public class BoardModifyServiceImpl implements BoardModifyService{
	@Autowired
	BoardDAO dao;
	//게시글 수정
	public void modifyBrd(HttpServletRequest req) {
		dao.modifyBrd(req);
	}
}
