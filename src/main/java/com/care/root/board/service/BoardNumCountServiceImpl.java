package com.care.root.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.board.dao.BoardDAO;
@Service
public class BoardNumCountServiceImpl implements BoardNumCountService{
	@Autowired
	BoardDAO dao;
	//게시글 수
	public int countBrd() {
		return dao.countBrd();
	}
}
