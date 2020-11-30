package com.care.root.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.board.dao.BoardDAO;
import com.care.root.board.dto.BoardDTO;
@Service
public class BoardViewServiceImpl implements BoardViewService {
	@Autowired
	BoardDAO dao;
	//게시글 보기
	public BoardDTO viewBoard(String id) {
		return dao.viewBoard(id);
	}
}
