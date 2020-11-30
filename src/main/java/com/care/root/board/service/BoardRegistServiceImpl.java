package com.care.root.board.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.board.dao.BoardDAO;
@Service
public class BoardRegistServiceImpl implements BoardRegistService{
	@Autowired
	BoardDAO dao;
	//게시판 글 등록
	public void registBoard(HttpServletRequest req) {
		dao.registBoard(req);
	}
}
