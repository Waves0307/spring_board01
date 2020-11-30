package com.care.root.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.board.dao.BoardDAO;
@Service
public class BoardListServiceImpl implements BoardListService {
	@Autowired
	BoardDAO dao;
	//게시판 목록 출력
	public void boardList(Model model, String start) {
		model.addAttribute("brdList",dao.boardList(start));
	}
}
